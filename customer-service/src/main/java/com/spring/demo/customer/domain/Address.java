package com.spring.demo.customer.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
public class Address {

    private Long id;

    @NotNull
    private AddressType addressType;

    private String streetAddress;
    
    @NotNull
    private String city;

    @NotNull
    private String stateCode;

    @NotNull
    private String country;

    @NotNull
    private String zipCode;
}
