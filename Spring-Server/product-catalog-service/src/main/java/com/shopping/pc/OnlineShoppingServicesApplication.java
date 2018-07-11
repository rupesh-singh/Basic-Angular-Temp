package com.shopping.pc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.shopping.pc.model.Product;
import com.shopping.pc.model.Review;
import com.shopping.pc.repository.ProductRepository;
import com.shopping.pc.repository.ProductRepositoryImple;
import com.shopping.pc.repository.ReviewRepository;
import com.shopping.pc.repository.ReviewRepositoryImpl;

@SpringBootApplication
@EnableTransactionManagement
public class OnlineShoppingServicesApplication {

	public static void main(String[] args) {

		SpringApplication.run(OnlineShoppingServicesApplication.class, args);
	}

}
