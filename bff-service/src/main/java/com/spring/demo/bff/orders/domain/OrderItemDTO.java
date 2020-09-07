package com.spring.demo.bff.orders.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by "Sunit Chatterjee" created on 07/09/20
 */
@Data
@Builder
@AllArgsConstructor
public class OrderItemDTO {
    private ProductDTO product;
    private BigDecimal quantity;
    private BigDecimal unitPrice;
    public BigDecimal totalCost;
}
