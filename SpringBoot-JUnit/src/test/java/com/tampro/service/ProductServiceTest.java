package com.tampro.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.impl.ProductServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

	@Mock
	ProductRepository productRepository;
	
	@InjectMocks
	ProductServiceImpl serviceImpl;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCreateUser() {
		Product product = new Product("Oshi Bắp", new BigDecimal(150));
		when(
				productRepository.save(product)
				).thenReturn(product);
		assertEquals(product, serviceImpl.create(product));
	}
	
	
	@Test
	public void testGetAll() {
		List<Product> list = Arrays.asList(new Product("Oshi Bắp", new BigDecimal(150)),
			new Product("Sữa", new BigDecimal(250)),new Product("Trà chanh", new BigDecimal(750)));
		
		when( productRepository.findAll()).thenReturn(list);
		
		assertEquals(list, serviceImpl.getAll());
		
	}
	@Test
	public void testGetProduct() {
		Product product = new Product("Oshi Bắp", new BigDecimal(150));
		when( productRepository.findById(Mockito.anyLong())).thenReturn(product);	
		assertEquals(product, serviceImpl.getProductById(1));
	
	} 
	 
	 
	
}
