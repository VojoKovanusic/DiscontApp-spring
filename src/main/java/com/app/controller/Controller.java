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

import com.app.entity.Product;
import com.app.service.ServiceOtherUsersWhoRecentlyPurchased;
import com.app.service.ServiceProducts;
import com.app.service.ServicePurchaBbyProduct;
import com.app.service.ServicePurchasesByUser;

@RestController
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class Controller {

	@Autowired
	private ServicePurchasesByUser servicePurchasesByUser;
	@Autowired
	private ServicePurchaBbyProduct purchasesByProduct;
	@Autowired
	private ServiceProducts serviceProduct;
	@Autowired
	private ServiceOtherUsersWhoRecentlyPurchased service;
	
	// fetch 5 recent purchases for the user, oreder by date
	@RequestMapping(path = "api/purchases/by_user/{username:.+}", method = RequestMethod.GET)
	public String allPurchasesByUser(@PathVariable String username) throws IOException {

		ArrayList<String> listpurchase = servicePurchasesByUser.getPurchasesByUsername(username);
		
		return listpurchase.toString();

	}

	// list of all people who previously purchased that product
	@RequestMapping(path = "api/purchases/by_product/{product_id}", method = RequestMethod.GET)
	public String peopleWhoPreviouslyPurchasedProduct(@PathVariable int product_id) {
		
		List<String> listpurchase = purchasesByProduct.peopleWhoPreviouslyPurchasedProduct(product_id);
		 
		return listpurchase.toString();

	}

	// info about the products
	@RequestMapping(path = "api/products/{product_id}", method = RequestMethod.GET)
	public String getProductByID(@PathVariable int product_id) {

		 
		return serviceProduct.getProduct(product_id);

	}
	 
	@RequestMapping(path = "/api/recent_purchases/{username:.+}", method = RequestMethod.GET)
	public String recentPurchasesByUsername(@PathVariable String username) {
		
		return service.usersWhoRecentlyPurchased(username).toString();
	}
	 
	// info about the products
		@RequestMapping(path = "api/products/", method = RequestMethod.GET)
		public List<Product> getAllProducts() {

			return serviceProduct.getAllProducts();

		}

	
	
}
