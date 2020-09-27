package com.spring.demo.bff.orders;

import com.spring.demo.bff.orders.client.CustomerClient;
import com.spring.demo.bff.orders.client.OrderClient;
import com.spring.demo.bff.orders.client.ProductClient;
import com.spring.demo.bff.orders.client.domain.*;
import com.spring.demo.bff.orders.domain.*;
import io.opentracing.Scope;
import io.opentracing.Span;
import io.opentracing.Tracer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by "Sunit Chatterjee" created on 07/09/20
 */
@Service
@Log4j2
public class BFFOrderService {

    @Autowired
    private Tracer tracer;

    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private OrderClient orderClient;

    public List<Customer> getAllCustomers(String pageNumber, String pageSize) {
        log.info("Fetching all customers: pageNum = {}, pageSize = {}", pageNumber, pageSize);
        List<Customer> customers = customerClient.getCustomers(pageNumber, pageSize);
        log.info("Got {} customer records", customers.size());
        return customers;
    }

    
    public CustomerOrderDTO getAllOrderForCustomer(String customerId) {
        Span span = tracer.buildSpan("BFFOrderService.GetAllOrdersForCustomer").start();

        try (Scope scope = tracer.scopeManager().activate(span)) {
            log.info("Fetch all orders for customer: {}", customerId);

            log.info("Fetching customer details : {}", customerId);
            Customer customerDetail = customerClient.getCustomerDetail(customerId);

            log.info("Fetching orders for customer : {}", customerId);
            List<Order> ordersForClient = orderClient.getOrdersForClient(customerId);

            log.info("Got {} orders", ordersForClient.size());

            List<OrderDTO> orders =
                    ordersForClient.stream().map(order -> {
                        log.info("Fetching details for order");
                        List<OrderItemDTO> orderItems = order.getOrderItems().stream().map(orderItem -> {
                            Product productDetail = fetchProductDetails(orderItem);
                            return convertToOrderItemDTO(orderItem, productDetail);
                        }).collect(Collectors.toList());

                        log.info("Creating OrderDTO");
                        return convertToOrderDTO(order, orderItems);
                    }).collect(Collectors.toList());


            return CustomerOrderDTO.builder()
                    .customer(convertToCustomerDTO(customerDetail))
                    .orders(orders)
                    .build();
        }finally {
            span.finish();
        }

    }

    private Product fetchProductDetails(OrderItem orderItem) {
        log.info("Fetching product details for product : {}", orderItem.getProductId());
        Product productDetail = productClient.getProductDetail(orderItem.getProductId());
        return productDetail;
    }

    private CustomerDTO convertToCustomerDTO(Customer customer) {
        log.info("Creating Customer DTO");
        AddressDTO addressDTO = customer.getAddresses().stream()
                .filter(address -> AddressType.BILLING.equals(address.getAddressType()))
                .findFirst()
                .map(address ->
                        AddressDTO.builder()
                                .city(address.getCity())
                                .country(address.getCountry())
                                .stateCode(address.getStateCode())
                                .streetAddress(address.getStreetAddress())
                                .zipCode(address.getZipCode())
                                .build())
                .orElse(null);

        return CustomerDTO.builder()
                .id(customer.getCustomerGuid())
                .emailAddress(customer.getEmailAddress())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .gender(customer.getGender())
                .billingAddress(addressDTO)
                .build();
    }

    private OrderDTO convertToOrderDTO(Order order, List<OrderItemDTO> orderItems) {
        return OrderDTO.builder()
                .id(order.getId())
                .orderDate(order.getOrderDate())
                .orderItems(orderItems)
                .orderStatus(order.getOrderStatus())
                .totalCost(order.getTotalCost())
                .build();
    }

    private OrderItemDTO convertToOrderItemDTO(OrderItem item, Product productDetail) {
        Span span = tracer.buildSpan("BFFOrderService.convertToOrderItemDTO").start();
        try (Scope scope = tracer.scopeManager().activate(span)) {
            ProductDTO productDTO = convertToProductDTO(productDetail);

            return OrderItemDTO.builder()
                    .product(productDTO)
                    .quantity(item.getQuantity())
                    .unitPrice(item.getUnitPrice())
                    .totalCost(item.itemCost)
                    .build();
        }finally {
            span.finish();
        }
    }

    private ProductDTO convertToProductDTO(Product productDetail) {
        Span span = tracer.buildSpan("BFFOrderService.convertToProductDTO").start();
        try(Scope scope = tracer.scopeManager().activate(span)) {

            return ProductDTO.builder()
                    .id(productDetail.getProductGuid())
                    .brand(productDetail.getBrand())
                    .category(productDetail.getCategory().getName())
                    .name(productDetail.getName())
                    .ratings(productDetail.getRatings())
                    .build();
        }finally {
            span.finish();
        }
    }
}
