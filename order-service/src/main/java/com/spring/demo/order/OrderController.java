package com.spring.demo.order;

import com.spring.demo.common.ErrorMessage;
import com.spring.demo.order.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/customer/{guid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getOrdersForCustomer(@PathVariable(name = "guid") String customerGuid) {
        try {
            List<Order> orders = orderService.getOrdersForCustomer(customerGuid);
            return ResponseEntity.ok(orders);
        }catch(Exception ex) {
            return handleException(ex);
        }
    }


    private ResponseEntity<ErrorMessage> handleException(Exception ex) {
        ex.printStackTrace();
        ErrorMessage error = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
