package com.spring.demo.product.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Generated(GenerationTime.ALWAYS)
    private Long id;

    private @NonNull String name;

    private @NonNull BigDecimal price;

    private @NonNull BigDecimal ratings;

    private @NonNull String brand;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CategoryEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    @JsonManagedReference
    private CategoryEntity category;


    @Column(name = "product_guid", columnDefinition = "uuid")
    @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
    @Generated(GenerationTime.ALWAYS)
    private UUID productGuid;


}
