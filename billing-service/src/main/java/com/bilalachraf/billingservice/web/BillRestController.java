package com.bilalachraf.billingservice.web;

import com.bilalachraf.billingservice.entities.Bill;
import com.bilalachraf.billingservice.repositories.BillRepository;
import com.bilalachraf.billingservice.repositories.CustomerServiceClient;
import com.bilalachraf.billingservice.repositories.InventoryServiceClient;
import com.bilalachraf.billingservice.repositories.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Path;

@RestController
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerServiceClient customerServiceClient;
    @Autowired
    private InventoryServiceClient inventoryServiceClient;

    @GetMapping("/bills/full/{id}")
    Bill getBill(@PathVariable(name="id") Long id){
        Bill bill=billRepository.findById(id).get();
        bill.setCustomer(customerServiceClient.findCustomerByID(bill.getCustomerID()));
        bill.setProductItems(productItemRepository.findAllByBillId(bill.getId()));
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(inventoryServiceClient.findProductByID(productItem.getProductID()));
        });
        return bill;
    }
}
