package com.shopping.pc.repository;

import java.util.List;

import com.shopping.pc.model.Product;
import com.shopping.pc.repository.exception.ProductNotFoundException;

public interface ProductRepository {
	
	List<Product> findAll();
	Product find(int id);
	List<Product> findByName(String name);

}
