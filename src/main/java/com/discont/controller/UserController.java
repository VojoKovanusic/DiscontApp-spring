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
import com.discont.service.PopularPurchaseService;
import com.discont.service.ProductService;
import com.discont.service.PurchaseService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UserController {

	private PurchaseService purchaseService;
	private ProductService serviceProduct;
	private PopularPurchaseService popularPurchaseService;

	public UserController(PurchaseService purchaseService, ProductService serviceProduct,
			PopularPurchaseService popularPurchaseService) {
		this.purchaseService = purchaseService;
		this.serviceProduct = serviceProduct;
		this.popularPurchaseService = popularPurchaseService;
	}

	// fetch 5 recent purchases for the user, oreder by date
	@GetMapping(path = "discont.com/purchases/by-user/{username:.+}")
	public ArrayList<Purchase> allPurchasesByUser(@PathVariable String username) throws IOException {

		return purchaseService.getPurchasesByUsername(username);

	}

	// list of all people who previously purchased that product
	@GetMapping(path = "discont.com/purchases/by-product/{productId}")
	public List<Purchase> peopleWhoPreviouslyPurchasedProduct(@PathVariable int productId) throws IOException {

		return purchaseService.peopleWhoPreviouslyPurchasedProduct(productId);

	}

	@GetMapping(path = "discont.com/products/{productId}")
	public Product getProductByID(@PathVariable int productId) {

		return serviceProduct.getProductById(productId);

	}

	@GetMapping(path = "discont.com/recent-purchases/{username:.+}")
	public ArrayList<PopularPurchase> recentPurchasesByUsername(@PathVariable String username) {

		return popularPurchaseService.usersWhoRecentlyPurchased(username);
	}

	@GetMapping(path = "discont.com/products")
	public List<Product> getAllProducts() {

		return serviceProduct.getAllProducts();

	}

}
