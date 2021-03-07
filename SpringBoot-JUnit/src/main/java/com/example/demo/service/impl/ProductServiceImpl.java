package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository proRepo;
	
	
	@Override
	public Product create(Product product) {
		// TODO Auto-generated method stub
		return proRepo.save(product);
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return proRepo.save(product);
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		proRepo.delete(product);
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return proRepo.findAll();
	}

	@Override
	public Product getProductById(long id) {
		// TODO Auto-generated method stub
		return proRepo.findById(id);
	}

}
