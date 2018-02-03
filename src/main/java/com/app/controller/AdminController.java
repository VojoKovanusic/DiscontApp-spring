package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Product;
import com.app.entity.User;
import com.app.service.ServiceProducts;
import com.app.service.ServiceUser;

@RestController
public class AdminController {
	@Autowired
	ServiceUser serviceUser;
	
	@Autowired
	ServiceProducts serviceproduct;
	
	@RequestMapping(path = "/add/user", method = RequestMethod.POST)
	public void addUser(@RequestBody User user) {
		 
		serviceUser.addUser(user);
	
	}

	@RequestMapping(path = "/add/product", method = RequestMethod.POST)
	public Product addProduct(@RequestBody Product product) {
		serviceproduct.addProduct(product);
		return product;
	}

	@RequestMapping(path = "/get", method = RequestMethod.GET)
	public List<User> getUsers() {
		 
		return serviceUser.getUsers();
	}
	
	@RequestMapping(value = "delete/product/{id}", method = RequestMethod.DELETE)
	public boolean deleteUser(@PathVariable Long id) {
		Product product = this.serviceproduct.getAllProducts().stream().filter(user -> user.getId() == id).findFirst().orElse(null);
		if (product != null) {
			serviceproduct.remove(product);
			return true;
		} 
			return false;
		}
 
 
	}

