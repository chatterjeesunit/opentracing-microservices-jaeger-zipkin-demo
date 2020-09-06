package com.spring.demo.order.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Order {

    private Long id;

    @NotNull
    private String customerId;

    @NotNull
    private ZonedDateTime orderDate;

    @NotNull
    private OrderStatus orderStatus;

    private List<OrderItem> orderItems;

    public BigDecimal totalCost() {
        return orderItems.stream()
                .map(OrderItem::getItemCost)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
