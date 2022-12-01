package com.bilalachraf.billingservice.repositories;

import com.bilalachraf.billingservice.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerServiceClient {
    @GetMapping("/customers/{id}?projection=fullCustomer")
    Customer findCustomerByID(@PathVariable("id") Long id);
}
