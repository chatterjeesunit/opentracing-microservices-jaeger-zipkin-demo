package com.spring.demo.order.domain;

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

    @NotNull
    private Long orderId;

    @NotNull
    private String productId;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    public BigDecimal getItemCost() {
        return unitPrice.multiply(quantity);
    }
}
