package com.shopping.pc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.pc.model.Product;
import com.shopping.pc.repository.ProductRepository;

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
	public @ResponseBody Product findProductById(@PathVariable("id") int id) {
		// System.out.println("Updating User " + id);
		return productRepository.find(id);
	}

	@RequestMapping(value = "/api/products", method = RequestMethod.GET, params = { "name" })
	public @ResponseBody List<Product> findProductsByName(@RequestParam() String name) {
		// System.out.println("Updating User " + name);
		return productRepository.findByName(name);
	}

}
