package com.spring.demo.bff.orders.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
public class Category {

    private Long id;

    @NotNull
    private String name;
}
