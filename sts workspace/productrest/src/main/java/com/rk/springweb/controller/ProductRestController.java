package com.rk.springweb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rk.springweb.entities.Product;
import com.rk.springweb.repo.ProductRepository;

@RestController
public class ProductRestController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ProductRestController.class);
	
	@Autowired
	private ProductRepository repository;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> getProducts() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public Product findProduct(@PathVariable("id") int id) {
		LOGGER.info("finding product by id: " + id);
		return repository.findById(id).get();
	}
	
	@RequestMapping(value = "/products/", method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		return repository.save(product);
	}
	
	@RequestMapping(value = "/products/", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		return repository.save(product);
	}
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		repository.deleteById(id);
	}
}
