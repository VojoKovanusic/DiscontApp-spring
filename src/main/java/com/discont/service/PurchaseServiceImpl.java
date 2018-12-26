package com.discont.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.discont.entity.Purchase;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

	private UserService serviceUser;

	private RestTemplate restTemplate;

	@Value("${rest.purchase.url.purchase.user}")
	private String purchaseByUserUrl;

	@Autowired
	public PurchaseServiceImpl(UserService serviceUser, RestTemplate restTemplate) {
	 
		this.serviceUser = serviceUser;
		this.restTemplate = restTemplate;
	}

	@Override
	public List<Purchase> getAllPurchases() {

		ArrayList<Purchase> listofAllPurchase = new ArrayList<>();

		for (String username : serviceUser.getUserNames()) {
			String URL = purchaseByUserUrl.replace("{username}", username);

			ArrayList<Purchase> purchasesByUsername = loadPurchasesByUsername(restTemplate, URL);

			loadAllPurchases(listofAllPurchase, purchasesByUsername);

		}

		return listofAllPurchase;

	}

	private void loadAllPurchases(ArrayList<Purchase> listofAllPurchase, ArrayList<Purchase> purchasesByUsername) {
		for (Purchase purchas : purchasesByUsername) {
			listofAllPurchase.add(purchas);
		}
	}

	private ArrayList<Purchase> loadPurchasesByUsername(RestTemplate restTemplate, String URL) {
		ArrayList<Purchase> purchasesByUsername = restTemplate.getForObject(URL, HelperPurchasClass.class)
				.getPurchases();
		return purchasesByUsername;
	}

	@Override
	@Cacheable(value = "purchasesByUsername", key = "#username")
	public ArrayList<Purchase> getPurchasesByUsername(String username) throws IOException {

		String URL = purchaseByUserUrl.replace("{username}", username);

		ArrayList<Purchase> purchasesByUsername = restTemplate.getForObject(URL, HelperPurchasClass.class)
				.getPurchases();

		return getFiveRecentPurchases(purchasesByUsername);
	}

	private ArrayList<Purchase> getFiveRecentPurchases(ArrayList<Purchase> listpurchase) {

		ArrayList<Purchase> recentFive = new ArrayList<>();

		Collections.sort(listpurchase);

		if (listpurchase.size() <= 5)
			return listpurchase;
		for (int i = 0; i < 5; i++) {
			recentFive.add(listpurchase.get(i));
		} 
		return recentFive;
	}
	
	@Override
	@Cacheable(value = "ppp", key = "#productId")
	public ArrayList<Purchase> peopleWhoPreviouslyPurchasedProduct(int productId) {

		ArrayList<Purchase> purchase = new ArrayList<>();

		for (Purchase purchas : getAllPurchases()) {
			if (purchas.getProductId() == (productId)) {
				purchase.add(purchas);
			}
		} 
		return purchase;
	}

 
	@CacheEvict(value = "purchasesByUsername", key = "#username")
	public void cacheEvictByUsername(String username) {

	}
	//ppp==peopleWhoPreviouslyPurchasedProduct
	@CacheEvict(value = "ppp", key = "#productId")
	public void cacheEvictPpp(String productId) {

	} 

}

class HelperPurchasClass {

	@JsonProperty("purchases")
	private ArrayList<Purchase> purchases;

	ArrayList<Purchase> getPurchases() {
		return purchases;
	}

}