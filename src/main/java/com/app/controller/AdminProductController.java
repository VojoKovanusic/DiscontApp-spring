package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.app.entity.Product;
import com.app.service.ServiceProducts;


@RestController
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class AdminProductController {

	
	@Autowired
	ServiceProducts serviceproduct;
	

	@PostMapping(path = "/product")
	public Product addProduct(@RequestBody Product product) {
		System.out.println("product add "+product.toString());
		serviceproduct.addProduct(product);
		return product;
	}

	@PutMapping(path = "/product")
	public Product updateProduct(@RequestBody Product product) {
		System.out.println("product update "+product.toString());
		serviceproduct.updateProduct(product);
		return product;
	}
	
	@DeleteMapping(value = "/product/{id}")
	public boolean deleteProduct(@PathVariable Long id) {
		Product product = this.serviceproduct.getAllProducts().stream().filter(user -> user.getId() == id).findFirst().orElse(null);
		if (product != null) {
			serviceproduct.remove(product);
			System.out.println("Obrisan-"+product.toString());
		 return true;
		}
		return false; } 
 
	} 

