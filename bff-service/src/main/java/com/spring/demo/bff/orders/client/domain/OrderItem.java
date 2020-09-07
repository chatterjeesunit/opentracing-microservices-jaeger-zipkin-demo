package com.spring.demo.bff.orders.client.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
public class OrderItem {

    private Long id;
    private Long orderId;
    private String productId;
    private BigDecimal quantity;
    private BigDecimal unitPrice;
    public BigDecimal itemCost;
}
