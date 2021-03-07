package com.tampro.controller;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.SpringBootJUnitApplication;
import com.example.demo.controller.ProductController;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class)
@ContextConfiguration(classes = SpringBootJUnitApplication.class)
public class ProductControllerTest {

	
	MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;

	@MockBean
	private ProductService productService;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	String productJson = "{\"name\":\"Sting\",\"price\":\"150\"}";
	//\"id\":\"1\",
	@Test
	public void createProduct() throws Exception {
		Product product = new Product(1,"Sting", new BigDecimal(150));
		Mockito.when(
				productService.create(Mockito.any(Product.class))
				).thenReturn(product);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/products")
							.accept(MediaType.APPLICATION_JSON).content(productJson)
							.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.CREATED.value(),  response.getStatus());
		assertEquals("http://localhost/api/v1/products/1", response.getHeader(HttpHeaders.LOCATION));		
	}
	@Test
	public void getProduct() throws Exception {
		Product product = new Product(1,"Sting", new BigDecimal(150));
		Mockito.when(productService.getProductById(Mockito.anyLong())).thenReturn(product);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/products/1")
														.accept(MediaType.APPLICATION_JSON).content(productJson)
														.contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = 	mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response =	mvcResult.getResponse();	
		String jsonValue = "{id:1,name:Sting,price:150}";
		System.out.println(response.getContentAsString());
		JSONAssert.assertEquals(jsonValue, response.getContentAsString(), true);
	}


}
