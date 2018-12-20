package com.discont.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RestController;

import com.discont.entity.PopularPurchase;
import com.discont.entity.Product;
import com.discont.entity.Purchase;
import com.discont.service.ServiceProducts;
import com.discont.service.ServicePurchaseByProduct;
import com.discont.service.ServicePurchaseByUser;
import com.discont.service.ServiceUsersWhoRecentlyPurchased;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UserController {

	@Autowired
	private ServicePurchaseByUser servicePurchasesByUser;
	@Autowired
	private ServicePurchaseByProduct purchasesByProductService;
	@Autowired
	private ServiceProducts serviceProduct;
	@Autowired
	private ServiceUsersWhoRecentlyPurchased service;

	// fetch 5 recent purchases for the user, oreder by date
	@GetMapping(path = "discont.com/purchases/by-user/{username:.+}")
	public ArrayList<Purchase> allPurchasesByUser(@PathVariable String username) throws IOException {

		return servicePurchasesByUser.getPurchasesByUsername(username);

	}

	// list of all people who previously purchased that product
	@GetMapping(path = "discont.com/purchases/by-product/{productId}")
	public ArrayList<Purchase> peopleWhoPreviouslyPurchasedProduct(@PathVariable int productId) {

		return purchasesByProductService.peopleWhoPreviouslyPurchasedProduct(productId);

	}

	@GetMapping(path = "discont.com/products/{productId}")
	public Product getProductByID(@PathVariable int productId) {

		return serviceProduct.getProductById(productId);

	}

	@GetMapping(path = "discont.com/recent-purchases/{username:.+}")
	public ArrayList<PopularPurchase> recentPurchasesByUsername(@PathVariable String username) {

		return service.usersWhoRecentlyPurchased(username);
	}

	@GetMapping(path = "discont.com/products")
	public List<Product> getAllProducts() {

		return serviceProduct.getAllProducts();

	}

}
