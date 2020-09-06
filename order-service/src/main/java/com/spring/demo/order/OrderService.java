package com.spring.demo.order;

import com.spring.demo.order.domain.Order;
import com.spring.demo.order.entity.OrderEntity;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;


    public List<Order> getOrdersForCustomer(String customerGuid) {
        log.info("Fetching orders by customer guid: {}", customerGuid);
        UUID guid = UUID.fromString(customerGuid);
        List<OrderEntity> orders = orderRepository.findAllOrdersByCustomerId(guid);
        return modelMapper.map(orders, new TypeToken<List<Order>>(){}.getType());
    }
}
