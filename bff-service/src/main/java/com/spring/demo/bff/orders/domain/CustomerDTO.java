package com.spring.demo.bff.orders.domain;

import com.spring.demo.bff.orders.client.domain.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Created by "Sunit Chatterjee" created on 07/09/20
 */
@Data
@Builder
@AllArgsConstructor
public class CustomerDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Gender gender;
    private AddressDTO billingAddress;
}
