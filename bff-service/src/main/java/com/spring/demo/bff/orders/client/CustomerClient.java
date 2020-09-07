package com.spring.demo.bff.orders.client;

import com.spring.demo.bff.orders.client.domain.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("customers")
public interface CustomerClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/customer/")
    List<Customer> getCustomers(@RequestParam("pageNum") String pageNum, @RequestParam("pageSize") String pageSize);

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/customer/{customerId}")
    Customer getCustomerDetail(@PathVariable("customerId") String customerId);

}
