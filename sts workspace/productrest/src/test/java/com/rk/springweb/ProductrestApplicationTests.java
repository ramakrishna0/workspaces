package com.rk.springweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.rk.springweb.entities.Product;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductrestApplicationTests {
	@Value("${productrestapi.services.url}")
	private String restURL;
	
	@Test
	public void testGetProducts() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(restURL + "1", Product.class);
		assertNotNull(product);
		assertEquals("iPhone", product.getName());
	}
	
	@Test
	public void testCreateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();
		product.setName("Samsung");
		product.setDescription("A phone");
		product.setPrice(1099);
		
		Product postForObject = restTemplate.postForObject(restURL, product, Product.class);
		assertNotNull(postForObject);
		assertNotNull(postForObject.getId());
		assertEquals(postForObject.getName(), product.getName());
	}
	
	@Test
	public void testUpdateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(restURL + "1", Product.class);
		product.setPrice(899);
		restTemplate.put(restURL, product);
	}

}
