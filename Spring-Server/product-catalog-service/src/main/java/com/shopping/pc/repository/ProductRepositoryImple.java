package com.shopping.pc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.shopping.pc.model.Product;

@Repository(value = "productRepository")
public class ProductRepositoryImple implements ProductRepository {

	@PersistenceContext
	private EntityManager entityManager = null;

	@Override
	public List<Product> findAll() {
		// System.out.println("up and running");
		String jpql = "from Product p";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Product find(int id) {

		return entityManager.find(Product.class, id);
	}

	@Override
	public List<Product> findByName(String name) {
		
		Query query = entityManager.createQuery("from Product where name like :arg1");
		query.setParameter("arg1", "%"+name+"%");
		return query.getResultList();
	}

}
