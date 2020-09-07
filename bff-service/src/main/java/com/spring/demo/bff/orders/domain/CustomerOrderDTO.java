package com.spring.demo.bff.orders.domain;

import com.spring.demo.bff.orders.client.domain.Customer;
import lombok.*;

import java.util.List;

/**
 * Created by "Sunit Chatterjee" created on 07/09/20
 */
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CustomerOrderDTO {
    
    private Customer customer;
    private List<OrderDTO> orders;

}

