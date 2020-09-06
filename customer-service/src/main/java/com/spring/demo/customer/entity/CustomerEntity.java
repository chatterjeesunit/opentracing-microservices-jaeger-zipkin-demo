package com.spring.demo.customer.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.demo.common.db.PostgreSQLEnumType;
import com.spring.demo.customer.domain.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity(name = "customer")
@TypeDef(name = "gender", typeClass = PostgreSQLEnumType.class)
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Generated(GenerationTime.ALWAYS)
    private Long id;

    @Column(name = "first_name")
    private @NonNull String firstName;

    @Column(name = "last_name")
    private @NonNull String lastName;

    @Column(name = "email_address")
    private @NonNull String emailAddress;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, targetEntity = AddressEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    @JsonManagedReference
    private List<AddressEntity> addresses;

    @Enumerated(EnumType.STRING)
    @Type(type = "gender")
    private Gender gender;

    @Column(name = "customer_guid", columnDefinition = "uuid")
    @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
    @Generated(GenerationTime.ALWAYS)
    private UUID customerGuid;


}
