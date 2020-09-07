package com.spring.demo.order.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.demo.order.domain.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;


@Data
@NoArgsConstructor
@Entity(name = "order_items")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Generated(GenerationTime.ALWAYS)
    private Long id;

    @Column(name = "product_id", columnDefinition = "uuid")
    @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
    @Generated(GenerationTime.ALWAYS)
    private UUID productId;

    @NotNull
    private BigDecimal quantity;

    @NotNull
    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @ManyToOne
    @JsonBackReference
    private OrderEntity order;
}
