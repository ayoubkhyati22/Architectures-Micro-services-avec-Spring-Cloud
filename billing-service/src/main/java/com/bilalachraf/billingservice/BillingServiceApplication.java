package com.bilalachraf.billingservice;

import com.bilalachraf.billingservice.entities.Bill;
import com.bilalachraf.billingservice.entities.ProductItem;
import com.bilalachraf.billingservice.repositories.BillRepository;
import com.bilalachraf.billingservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BillRepository repository, ProductItemRepository productItemRepository) {
		return args -> {
			for (int i = 0; i < 30; i++) {

				Bill b = repository
						.save(new Bill(null, Math.random() * 100000, null, (long) ((Math.random() * 4) + 1), null));
				for (int j = 0; j < 3; j++) {
					productItemRepository.save(
							new ProductItem(
									null,
									(long) (Math.random() * 30) + 1,
									Math.random() * 20000,
									(Math.random() * 1500),
									b,
									null));
				}
			}
		};
	}

}
