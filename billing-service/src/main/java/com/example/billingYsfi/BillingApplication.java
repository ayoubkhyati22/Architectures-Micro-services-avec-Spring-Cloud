package com.example.billingYsfi;

import com.example.billingYsfi.entity.Bill;
import com.example.billingYsfi.entity.ProductItem;
import com.example.billingYsfi.feign.CustomerServiceClient;
import com.example.billingYsfi.feign.InventoryServiceClient;
import com.example.billingYsfi.model.Customer;
import com.example.billingYsfi.model.Product;
import com.example.billingYsfi.repository.BillRepository;
import com.example.billingYsfi.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@EnableFeignClients
public class BillingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingApplication.class, args);

	}

	@Bean
	CommandLineRunner start(

			BillRepository billRepository,
			ProductItemRepository productItemRepository,
			CustomerServiceClient customerRestClient,
			InventoryServiceClient productItemRestClient ){
					return args -> {
			Customer customer=customerRestClient.getCustomerById(1L);
			Bill bill1=billRepository.save(new Bill(null,new Date(),null,customer.getId(),null));
			PagedModel<Product> productPagedModel=productItemRestClient.findAll();
						AtomicInteger i= new AtomicInteger(1);
						PagedModel<Product>prductPageModel=productItemRestClient.findAll();
						prductPageModel.forEach(p->{
									ProductItem productItem=new ProductItem();
									productItem.setProductID(i.getAndIncrement());
									productItem.setName(p.getName());
//                         System.out.println("re  "+p.getId());
									productItem.setPrice(p.getPrice());
									productItem.setQuantity(1+new Random().nextInt(100));
									productItem.setBill(bill1);
									productItemRepository.save(productItem);
								}
						);
			/*
			productPagedModel.forEach(p->{
				ProductItem productItem=new ProductItem();
				productItem.setPrice(p.getPrice());
				productItem.setQuantity(1+new Random().nextInt(100));
				productItem.setBill(bill1);
				productItemRepository.save(productItem);
			}
			);

			 */

			/*
			System.out.println("------------------------");
						System.out.println(customer.getId());
						System.out.println(customer.getName());
						System.out.println(customer.getEmail());
			 */


};}}
