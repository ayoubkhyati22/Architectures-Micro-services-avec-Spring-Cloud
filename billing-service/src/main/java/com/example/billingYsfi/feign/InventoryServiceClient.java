package com.example.billingYsfi.feign;

import com.example.billingYsfi.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.QueryParam;

@FeignClient(name="inventory-service")
public interface InventoryServiceClient {
    @GetMapping("/products/{id}?projection=fullProduct")
    Product findProductById(@PathVariable("id") Long id);
    @GetMapping("/products")
      PagedModel<Product> findAll();
    @GetMapping(path = "/products/{id}")
        Product getProductById(@PathVariable("id") Long id);


//    @GetMapping("/products")
//    static PagedModel<Product> pageProducts() {
//        return null;
//    }

}
