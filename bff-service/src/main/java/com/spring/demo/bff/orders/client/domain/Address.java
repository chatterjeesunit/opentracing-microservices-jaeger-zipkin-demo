package com.spring.demo.bff.orders.client.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Address {

    private Long id;
    private AddressType addressType;
    private String streetAddress;
    private String city;
    private String stateCode;
    private String country;
    private String zipCode;
}
