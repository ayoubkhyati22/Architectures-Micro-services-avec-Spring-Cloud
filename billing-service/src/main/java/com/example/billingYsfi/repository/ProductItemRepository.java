package com.example.billingYsfi.repository;

import com.example.billingYsfi.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProductItemRepository extends
        JpaRepository<ProductItem,Long> {

    List<ProductItem> findByBillId(Long billID);
    List<ProductItem> findAll();


}
