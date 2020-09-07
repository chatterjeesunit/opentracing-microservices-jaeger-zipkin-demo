package com.spring.demo.bff.orders;

import com.spring.demo.bff.common.ErrorMessage;
import com.spring.demo.bff.orders.client.domain.Customer;
import com.spring.demo.bff.orders.domain.CustomerOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bff")
public class BFFOrderController {

    @Autowired
    private BFFOrderService BFFOrderService;


    @GetMapping(path = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllCustomers(
            @RequestParam("pageNum") String pageNumber,
            @RequestParam("pageSize") String pageSize) {
        try {
            List<Customer> customers = BFFOrderService.getAllCustomers(pageNumber, pageSize);
            return ResponseEntity.ok(customers);
        }catch(Exception ex) {
            return handleException(ex);
        }
    }


    @GetMapping(path = "/customer/{customerId}/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getOrdersForCustomer(@PathVariable("customerId") String customerId) {
        try {
            CustomerOrderDTO allOrderForCustomer = BFFOrderService.getAllOrderForCustomer(customerId);
            return ResponseEntity.ok(allOrderForCustomer);
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
