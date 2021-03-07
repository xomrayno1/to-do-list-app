package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {
	
	Product create(Product product);
	
	Product update(Product product);
	
	void delete(Product product);
	
	List<Product> getAll();
	
	Product getProductById(long id);

}
