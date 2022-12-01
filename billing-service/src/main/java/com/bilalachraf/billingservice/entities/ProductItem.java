package com.bilalachraf.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @ToString
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productID;
    private Double price;
    private  Double quantity;

    @ManyToOne
    private Bill bill;

    @Transient
    private Product product;

}
