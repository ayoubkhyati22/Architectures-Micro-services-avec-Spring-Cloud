package org.sid.inventoryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/addproduct")
    public void add(@RequestBody Product p) {
        service.addProduct(p);
    }

    @DeleteMapping("/deleteproduct/{id}")
    public String deleteLivre(@PathVariable int id) {
        return service.deleteProduct(id);
    }

}
