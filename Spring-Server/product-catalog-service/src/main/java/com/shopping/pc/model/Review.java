package com.shopping.pc.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "review", schema = "online_shop_db")
public class Review {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rid;
	private String stars;
	private String author;
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	public String getStars() {
		return stars;
	}
	public void setStars(String stars) {
		this.stars = stars;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getComment() {
		return comment;
	}
	public void setComent(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Review [stars=" + stars + ", author=" + author + ", coment=" + comment + "]";
	}
	public void setProduct(Product product2) {
		this.product=product2;
	}
	public Product getProduct() {
		return product;
	}
	
	
	
	
}
