package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
private CustomerRepository repository;

    //INSERT
    public void addCustomer(Customer p) {
        repository.save(p);
    }

    //DELETE
    public String deleteCustomer(int id) {
        repository.deleteById((long) id);
        return "Customer removed !! "+id;
    }

}
