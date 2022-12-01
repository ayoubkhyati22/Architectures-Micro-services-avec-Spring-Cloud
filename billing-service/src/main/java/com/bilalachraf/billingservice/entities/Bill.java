package com.bilalachraf.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Data @Entity @AllArgsConstructor @NoArgsConstructor @ToString
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    @OneToMany(mappedBy = "bill")
    @JsonIgnoreProperties
    private Collection<ProductItem> productItems;
    private Long customerID;
    @Transient
    private Customer customer;

}
