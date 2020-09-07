package com.spring.demo.bff.orders.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class Product {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private BigDecimal price;

    private BigDecimal ratings;

    private String brand;

    private Category category;

    private String productGuid;
}
