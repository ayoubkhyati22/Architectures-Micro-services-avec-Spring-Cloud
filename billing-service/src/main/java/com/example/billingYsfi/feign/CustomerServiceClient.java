package com.example.billingYsfi.feign;

import com.example.billingYsfi.model.Customer;
import com.example.billingYsfi.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="customer-service")
public interface CustomerServiceClient {
    @GetMapping("/customers/{id}?projection=fullCustomer")
    Customer getCustomerById(@PathVariable("id") Long id);

    @GetMapping("/customers")
    PagedModel<Customer> findAll();

}
