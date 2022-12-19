package com.example.billingYsfi.web;

import com.example.billingYsfi.entity.Bill;
import com.example.billingYsfi.entity.BillRequest;
import com.example.billingYsfi.entity.ProductItem;
import com.example.billingYsfi.exeption.ProductItemNotFoundException;
import com.example.billingYsfi.feign.CustomerServiceClient;
import com.example.billingYsfi.feign.InventoryServiceClient;
import com.example.billingYsfi.model.Customer;
import com.example.billingYsfi.model.Product;
import com.example.billingYsfi.repository.BillRepository;
import com.example.billingYsfi.repository.ProductItemRepository;
import com.example.billingYsfi.service.BillingService;
import com.example.billingYsfi.service.ProductItemService;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedModel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;


@RestController
public class BillingRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerServiceClient customerServiceClient;
    private InventoryServiceClient inventoryServiceClient;
    private ProductItemService productItemService;

    @Autowired
    private BillingService service;

    public BillingRestController(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerServiceClient customerServiceClient, InventoryServiceClient inventoryServiceClient, ProductItemService productItemService) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerServiceClient = customerServiceClient;
        this.inventoryServiceClient = inventoryServiceClient;
        this.productItemService = productItemService;

    }



    @GetMapping(path="fullBill/{id}")
    public Bill getBill(@PathVariable(name="id") Long id) throws ProductItemNotFoundException {
        Bill bill =billRepository.findById(id).get();

        Customer customer=customerServiceClient.getCustomerById(bill.getCustomerID());
        customerServiceClient.findAll().forEach(System.out::println);
        System.out.println(customer.getName());
        bill.setCustomer(customer);

        bill.getProductItems().forEach(pi->{
            System.out.println("id : "+pi.getId());
            Product product=inventoryServiceClient.getProductById(pi.getProductID());
           // pi.setProduct(product);
           // pi.setProductName(product.getName());
        });

        return bill;
    }

    @PostMapping("/addbill")
    public void add(@RequestBody BillRequest b){
        System.out.println("AddBill##########");
        System.out.println(b);
        Bill bill=billRepository.save(new Bill(null,new Date(),null, b.getCustomerID(),null));
        for (Long id:b.getProductIDs()) {
            Product p = inventoryServiceClient.getProductById(id);
            ProductItem productItem=new ProductItem();
            productItem.setPrice(p.getPrice());
            productItem.setQuantity(1+new Random().nextInt(100));
            productItem.setBill(bill);
            productItem.setName(p.getName());
            productItem.setProductID(p.getId());
            productItemRepository.save(productItem);

        }
    }
}
