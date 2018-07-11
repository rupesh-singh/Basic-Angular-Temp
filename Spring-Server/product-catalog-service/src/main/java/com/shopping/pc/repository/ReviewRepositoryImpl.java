package com.shopping.pc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.pc.model.Review;


@Repository(value = "reviewRepository")
@Transactional
public class ReviewRepositoryImpl implements ReviewRepository{

	@PersistenceContext
	private EntityManager entityManager = null;

	@Override
	public List<Review> loadReview(int id) {
		//System.out.println("hello");
		Query query = entityManager.createQuery("from Review where product_id=:id ");
		query.setParameter("id",id);
		return query.getResultList();
	}

	@Override
	public Review save(Review review) {
		System.out.println("save here");
		return entityManager.merge(review);
	}
	
	
	
	
	
}
