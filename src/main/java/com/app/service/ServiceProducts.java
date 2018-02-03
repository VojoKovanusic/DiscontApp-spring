package com.app.service;

import java.util.List;

import com.app.entity.Product;

public interface ServiceProducts {
	 
	String getProduct(int id) ;
	List<Product> getAllProducts();
	void addProduct(Product product);
	void remove(Product product);
}
