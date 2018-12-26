package com.discont.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.discont.entity.Product;
import com.discont.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CRUDController {

	@Autowired
	ProductService productService;

	@PostMapping(path = "api.discont.com/product")
	public Product addProduct(@RequestBody Product product) {

		productService.addProduct(product);

		return product;
	}

	@PutMapping(path = "api.discont.com/product/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {

		productService.updateProduct(id, product);

		return product;
	}

	@DeleteMapping(value = "api.discont.com/product/{id}")
	public void deleteProduct(@PathVariable Long id) {

		productService.deleteProduct(id);
	}

}
