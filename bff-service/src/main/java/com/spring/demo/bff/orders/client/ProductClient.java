package com.spring.demo.bff.orders.client;

import com.spring.demo.bff.orders.client.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("products")
public interface ProductClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/product/{productId}")
    Product getProductDetail(@PathVariable("productId") String productId);
}
