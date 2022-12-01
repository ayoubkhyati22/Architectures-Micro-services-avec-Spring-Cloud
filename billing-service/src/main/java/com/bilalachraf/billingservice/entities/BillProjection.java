package com.bilalachraf.billingservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullBill",types = Bill.class)
public interface BillProjection extends Projection{
    Long getId();
    Double getAmount();
}
