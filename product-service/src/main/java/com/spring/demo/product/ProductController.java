package com.spring.demo.product;

import com.spring.demo.common.ErrorMessage;
import com.spring.demo.product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/{guid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProductDetail(@PathVariable(name = "guid") String productGuid) {
        try {
            Product product = productService.getProductByGuid(productGuid)
                    .orElseThrow(()->new RuntimeException("Product does not exists"));
            return ResponseEntity.ok(product);
        }catch(Exception ex) {
            return handleException(ex);
        }
    }


    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllProducts(
            @RequestParam("pageNum") String pageNumber,
            @RequestParam("pageSize") String pageSize) {
        try {
            Integer pageNumberLong = Integer.valueOf(pageNumber);
            Integer pageSizeLong = Integer.valueOf(pageSize);
            //Create a new paginated search request.
            PageRequest pageRequest = PageRequest.of(pageNumberLong, pageSizeLong);
            List<Product> products = productService.findAll(pageRequest);
            return ResponseEntity.ok(products);
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
