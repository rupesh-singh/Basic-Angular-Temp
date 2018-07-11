package com.shopping.pc.repository;

import java.util.List;

import com.shopping.pc.model.Review;

public interface ReviewRepository {
	
	List<Review> loadReview(int id);
	
	public Review save(Review review);

}
