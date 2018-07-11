package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRepository = null;

	@RequestMapping(value = "/api/products", method = RequestMethod.GET)
	public @ResponseBody List<Product> getProducts() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	@RequestMapping(value = "/api/products/{id}", method = RequestMethod.GET)
	public @ResponseBody Product findProductsById(@PathVariable("id") int id) {
		System.out.println("Updating User " + id);
		return productRepository.find(id);
	}

	
	@RequestMapping(value = "/api/products/name/{name}", method = RequestMethod.GET)
	public @ResponseBody List<Product> findProductsByName(@PathVariable("name") String name) {
		System.out.println("Updating User " + name);
		return productRepository.findByName(name);
	}

}
