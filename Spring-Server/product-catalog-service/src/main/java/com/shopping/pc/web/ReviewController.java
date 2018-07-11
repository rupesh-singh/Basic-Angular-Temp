package com.shopping.pc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.pc.model.Product;
import com.shopping.pc.model.Review;
import com.shopping.pc.repository.ReviewRepository;

@CrossOrigin(origins="*")
@Controller
public class ReviewController {

	
	
	@Autowired
	private ReviewRepository reviewRepository = null;
	
	

	@RequestMapping(value = "/api/products/{prodId}/review", method = RequestMethod.GET)
	public @ResponseBody List<Review> findReview(@PathVariable("prodId") int id) {
		System.out.println("loading");
		return reviewRepository.loadReview(id);
	}
	
	
	@RequestMapping(value="/api/products/{productId}/review",method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public @ResponseBody Review post(@PathVariable int productId, @RequestBody ReviewForm form) {

		Product product=new Product();
		product.setId(productId);
		Review review=new Review();
		review.setStars(form.getStars());
		review.setAuthor(form.getAuthor());
		review.setComent(form.getComment());
		review.setProduct(product);
		return reviewRepository.save(review);
		
		
		
	}

}
