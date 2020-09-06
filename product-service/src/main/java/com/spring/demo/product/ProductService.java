package com.spring.demo.product;

import com.spring.demo.product.domain.Product;
import com.spring.demo.product.entity.ProductEntity;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Log4j2
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;


    public Optional<Product> getProductByGuid(String productGuid) {
        log.info("Fetching product by guid: {}", productGuid);
        UUID guid = UUID.fromString(productGuid);
        Optional<ProductEntity> productEntity = productRepository.findByProductGuid(guid);
        return productEntity.map(product -> modelMapper.map(product, Product.class));
    }


    public List<Product> findAll(Pageable pageable) {
        log.info("Fetching all products : page# = {}, pageSize={}", pageable.getPageNumber(), pageable.getPageSize());
        Page<ProductEntity> results = productRepository.findAll(pageable);
        List<ProductEntity> products = results.getContent();
        return modelMapper.map(products, new TypeToken<List<Product>>(){}.getType());
    }
}
