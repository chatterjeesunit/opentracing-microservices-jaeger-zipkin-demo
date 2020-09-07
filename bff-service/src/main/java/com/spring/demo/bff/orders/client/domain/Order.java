package com.spring.demo.bff.orders.client.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Order {

    private Long id;
    private String customerId;
    private ZonedDateTime orderDate;
    private OrderStatus orderStatus;
    private List<OrderItem> orderItems;
    public BigDecimal totalCost;
}
