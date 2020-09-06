package com.spring.demo.customer.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.demo.common.db.PostgreSQLEnumType;
import com.spring.demo.customer.domain.AddressType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity(name = "address")
@TypeDef(name = "address_type", typeClass = PostgreSQLEnumType.class)
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Type(type = "address_type")
    private AddressType addressType;

    private String streetAddress;
    private @NonNull String city;
    private @NonNull String stateCode;
    private @NonNull String country;
    private @NonNull String zipCode;

    @ManyToOne
    @JsonBackReference
    private CustomerEntity customer;

}
