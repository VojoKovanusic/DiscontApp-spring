package com.app.service;

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
import com.app.entity.Purchase;
import com.fasterxml.jackson.annotation.JsonProperty;

@Service
public class ServicePurchaseByUserImpl implements ServicePurchaseByUser {

	@Autowired
	private ServiceUser serviceUser;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${rest.purchase.url.purchase.user}")
	private String purchaseByUserUrl;
	
	
	@Override
	public List<Purchase> getAllPurchases() {

		ArrayList<Purchase> listofAllPurchase = new ArrayList<>();

		for (String username : serviceUser.getUserNames()) {
			String URL =  purchaseByUserUrl.replace("{username}", username) ;

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

		String URL =  purchaseByUserUrl.replace("{username}", username) ;
		 

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

	@CacheEvict(value = "purchasesByUsername", key = "#username")
	public void cacheEvict(String username) {

	}

}

class HelperPurchasClass {

	@JsonProperty("purchases")
	private ArrayList<Purchase> purchases;

	ArrayList<Purchase> getPurchases() {
		return purchases;
	}

}