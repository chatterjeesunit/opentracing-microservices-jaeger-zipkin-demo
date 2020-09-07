package com.spring.demo.bff.orders.domain;

import com.spring.demo.bff.orders.client.domain.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by "Sunit Chatterjee" created on 07/09/20
 */
@Data
@Builder
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private ZonedDateTime orderDate;
    private OrderStatus orderStatus;
    private List<OrderItemDTO> orderItems;
    public BigDecimal totalCost;
}
