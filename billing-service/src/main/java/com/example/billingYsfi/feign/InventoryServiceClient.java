package com.example.billingYsfi.feign;

import com.example.billingYsfi.entity.ProductItem;
import com.example.billingYsfi.model.Product;
import com.example.billingYsfi.repository.ProductItemRepository;
import com.example.billingYsfi.service.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;

@FeignClient(name="inventory-service")
@RestController
public interface InventoryServiceClient {




    @GetMapping("/products/{id}?projection=fullProduct")
    Product findProductById(@PathVariable("id") Long id);

    @GetMapping("/products")
    PagedModel<Product> findAll();

    @GetMapping(path = "/products/{id}")
    Product getProductById(@PathVariable("id") Long id);





}
