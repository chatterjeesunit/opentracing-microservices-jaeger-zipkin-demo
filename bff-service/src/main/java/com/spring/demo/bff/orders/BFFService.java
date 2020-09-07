package com.spring.demo.bff.orders;

import com.spring.demo.bff.orders.client.CustomerClient;
import com.spring.demo.bff.orders.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by "Sunit Chatterjee" created on 07/09/20
 */
@Service
public class BFFService {


    @Autowired
    private CustomerClient customerClient;


    public List<Customer> getAllCustomers(String pageNumber, String pageSize) {
        return customerClient.getCustomers(pageNumber, pageSize);
    }

}
