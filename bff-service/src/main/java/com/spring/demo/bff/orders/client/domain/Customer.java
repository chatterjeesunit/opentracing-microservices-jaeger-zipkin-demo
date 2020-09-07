package com.spring.demo.bff.orders.client.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private List<Address> addresses;
    private Gender gender;
    private String customerGuid;
}
