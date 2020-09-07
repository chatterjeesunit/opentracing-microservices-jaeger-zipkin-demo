package com.spring.demo.bff.orders.client.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal ratings;
    private String brand;
    private Category category;
    private String productGuid;
}
