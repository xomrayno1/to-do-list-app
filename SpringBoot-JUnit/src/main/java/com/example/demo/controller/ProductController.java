package com.example.demo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Product;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		product = productService.create(product);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
							.buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(location).body(product);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long id){
		Product product = productService.getProductById(id);
		if(product == null) {
			throw new ResourceNotFoundException("Product not found exception with id :" + id);
		}
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	 
}
