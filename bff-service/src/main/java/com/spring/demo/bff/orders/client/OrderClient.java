package com.spring.demo.bff.orders.client;

import com.spring.demo.bff.orders.client.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("orders")
public interface OrderClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/order/customer/{customerId}")
    List<Order> getOrdersForClient(@PathVariable("customerId") String customerId);

}
