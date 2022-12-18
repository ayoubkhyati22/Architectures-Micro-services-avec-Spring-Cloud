package com.example.billingYsfi.service;

import com.example.billingYsfi.entity.Bill;
import com.example.billingYsfi.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingService {
    @Autowired
    private BillRepository repository;

    //INSERT
    public void addBill(Bill b) {
        repository.save(b);
    }
}
