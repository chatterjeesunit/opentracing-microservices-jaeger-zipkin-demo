package com.spring.demo.bff.orders;

import com.spring.demo.bff.orders.client.CustomerClient;
import com.spring.demo.bff.orders.client.OrderClient;
import com.spring.demo.bff.orders.client.ProductClient;
import com.spring.demo.bff.orders.client.domain.Customer;
import com.spring.demo.bff.orders.client.domain.Order;
import com.spring.demo.bff.orders.client.domain.OrderItem;
import com.spring.demo.bff.orders.client.domain.Product;
import com.spring.demo.bff.orders.domain.CustomerOrderDTO;
import com.spring.demo.bff.orders.domain.OrderDTO;
import com.spring.demo.bff.orders.domain.OrderItemDTO;
import com.spring.demo.bff.orders.domain.ProductDTO;
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
    private CustomerClient customerClient;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private OrderClient orderClient;

    public List<Customer> getAllCustomers(String pageNumber, String pageSize) {
        return customerClient.getCustomers(pageNumber, pageSize);
    }

    
    public CustomerOrderDTO getAllOrderForCustomer(String customerId) {

        log.info("Fetching customer details : {}", customerId);
        Customer customerDetail = customerClient.getCustomerDetail(customerId);

        log.info("Fetching orders for customer : {}", customerId);
        List<Order> ordersForClient = orderClient.getOrdersForClient(customerId);

        log.info("Got {} orders", ordersForClient.size());

        List<OrderDTO> orders =
                ordersForClient.stream().map(order -> {
                    List<OrderItemDTO> orderItems = order.getOrderItems().stream().map(orderItem -> {
                        Product productDetail = fetchProductDetails(orderItem);
                        return convertToOrderItemDTO(orderItem, productDetail);
                    }).collect(Collectors.toList());

                    return convertToOrderDTO(order, orderItems);
                }).collect(Collectors.toList());


        return CustomerOrderDTO.builder()
                .customer(customerDetail)
                .orders(orders)
                .build();
    }

    private Product fetchProductDetails(OrderItem orderItem) {
        log.info("Fetching product details for product : {}", orderItem.getProductId());
        Product productDetail = productClient.getProductDetail(orderItem.getProductId());
        return productDetail;
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
        ProductDTO productDTO = convertToProductDTO(productDetail);

        return OrderItemDTO.builder()
                .product(productDTO)
                .quantity(item.getQuantity())
                .unitPrice(item.getUnitPrice())
                .totalCost(item.itemCost)
                .build();
    }

    private ProductDTO convertToProductDTO(Product productDetail) {
        return ProductDTO.builder()
                .id(productDetail.getProductGuid())
                .brand(productDetail.getBrand())
                .category(productDetail.getCategory().getName())
                .name(productDetail.getName())
                .ratings(productDetail.getRatings())
                .build();
    }
}
