package com.example.billingYsfi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillRequest {
    @Id
    private Long id;
    private Date billingDate;
    private Long customerID;
    @ElementCollection
    private List<Long> productIDs;
}