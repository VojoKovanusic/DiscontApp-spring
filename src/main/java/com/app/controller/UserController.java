package com.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.PopularPurchase;
import com.app.entity.Product;
import com.app.entity.Purchase;
import com.app.service.ServiceUsersWhoRecentlyPurchased;
import com.app.service.ServiceProducts;
import com.app.service.ServicePurchaseByProduct;
import com.app.service.ServicePurchaseByUser;

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
	@RequestMapping(path = "api/purchases/by_user/{username:.+}", method = RequestMethod.GET)
	public ArrayList<Purchase> allPurchasesByUser(@PathVariable String username) throws IOException {

		return servicePurchasesByUser.getPurchasesByUsername(username);

	}

	// list of all people who previously purchased that product
	@RequestMapping(path = "api/purchases/by_product/{product_id}", method = RequestMethod.GET)
	public ArrayList<Purchase> peopleWhoPreviouslyPurchasedProduct(@PathVariable int product_id) {

		return purchasesByProductService.peopleWhoPreviouslyPurchasedProduct(product_id);

	}

	@RequestMapping(path = "api/products/{product_id}", method = RequestMethod.GET)
	public Product getProductByID(@PathVariable int product_id) {

		return serviceProduct.getProductById(product_id);

	}

	@RequestMapping(path = "/api/recent_purchases/{username:.+}", method = RequestMethod.GET)
	public ArrayList<PopularPurchase> recentPurchasesByUsername(@PathVariable String username) {

		return service.usersWhoRecentlyPurchased(username);
	}

	@RequestMapping(path = "api/products/", method = RequestMethod.GET)
	public List<Product> getAllProducts() {

		return serviceProduct.getAllProducts();

	}

}
