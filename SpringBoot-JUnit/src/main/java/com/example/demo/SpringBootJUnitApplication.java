package com.example.demo;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@SpringBootApplication
public class SpringBootJUnitApplication implements CommandLineRunner{

	@Autowired
	ProductService productService;
	
	
	private static final Logger log = LoggerFactory.getLogger(SpringBootJUnitApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJUnitApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Product product = 	productService.create(new Product("Oshi",new BigDecimal(150)));
//		log.info("Save Complete : "+ product);
	}

}
