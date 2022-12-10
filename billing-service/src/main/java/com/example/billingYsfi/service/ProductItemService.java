package com.example.billingYsfi.service;
import com.example.billingYsfi.entity.ProductItem;
import com.example.billingYsfi.model.Product;
import com.example.billingYsfi.repository.ProductItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
@Slf4j
@Transactional
public class ProductItemService {
    @Autowired
    private ProductItemRepository repository;




}
