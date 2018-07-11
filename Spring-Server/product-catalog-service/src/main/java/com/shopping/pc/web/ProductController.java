package com.shopping.pc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.pc.model.Product;
import com.shopping.pc.model.Review;
import com.shopping.pc.repository.ProductRepository;
import com.shopping.pc.repository.ReviewRepository;
import com.shopping.pc.repository.exception.ProductNotFoundException;

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
		return productRepository.find(id);
	}

	@RequestMapping(value = "/api/products", method = RequestMethod.GET, params = { "name" })
	public @ResponseBody List<Product> findProductsByName(@RequestParam() String name) {
		return productRepository.findByName(name);
	}


	@ExceptionHandler(value = { ProductNotFoundException.class })
	public ResponseEntity<String> exceptionHandler(Throwable t) {
		return new ResponseEntity<String>(t.getMessage(), null, HttpStatus.NOT_FOUND);
	}

}
