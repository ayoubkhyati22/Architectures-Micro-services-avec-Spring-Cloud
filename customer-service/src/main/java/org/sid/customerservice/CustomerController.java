package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/addcustomer")
    public void add(@RequestBody Customer p) {
        service.addCustomer(p);
    }

    @DeleteMapping("/deletecustomer/{id}")
    public String deletecustomer(@PathVariable int id) {
        return service.deleteCustomer(id);
    }

}
