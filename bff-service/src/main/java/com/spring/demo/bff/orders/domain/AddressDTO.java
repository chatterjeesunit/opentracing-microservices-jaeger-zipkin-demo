package com.spring.demo.bff.orders.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Created by "Sunit Chatterjee" created on 07/09/20
 */
@Data
@Builder
@AllArgsConstructor
public class AddressDTO {
    private String streetAddress;
    private String city;
    private String stateCode;
    private String country;
    private String zipCode;
}
