package com.app.service;

import java.util.List;

import com.app.entity.Product;

public interface ServiceProducts {
	 
	Product getProductById(int id) ;
	List<Product> getAllProducts();
	void addProduct(Product product);
	void updateProduct(Long id,Product product);
	void remove(Product product);
	boolean deleteProduct(Long id);
}
