package com.app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.app.entity.Purchas;
import com.fasterxml.jackson.annotation.JsonProperty;


@Service
public class ServicePurchasesByUserImpl implements ServicePurchasesByUser {

	@Autowired
	private ServiceUser serviceUser;
 
	@Override
	public List<Purchas> getAllPurchases()  {
		 
		ArrayList<Purchas> listofAllPurchase = new ArrayList<>();
		RestTemplate restTemplate = new RestTemplate();
	 
		 for (String username : serviceUser.getUserName() ) {
			 String URL = "http://localhost:8000/api/purchases/by_user/"+username;
		 
			ArrayList<Purchas> purchasesByUsername = loadPurchasesByUsername(restTemplate, URL);

			loadAllPurchases(listofAllPurchase, purchasesByUsername);
	 
		 }
		 
		 
		return listofAllPurchase;
 
	}


	private void loadAllPurchases(ArrayList<Purchas> listofAllPurchase, ArrayList<Purchas> purchasesByUsername) {
		for (Purchas purchas : purchasesByUsername) {
			listofAllPurchase.add(purchas);
		}
	}


	private ArrayList<Purchas> loadPurchasesByUsername(RestTemplate restTemplate, String URL) {
		ArrayList<Purchas> purchasesByUsername =
				restTemplate.getForObject(URL,HelperPurchasClass.class)
				.getPurchases();
		return purchasesByUsername;
	}


	@Override
	@Cacheable(value = "purchasesByUsername", key = "#username")
	public ArrayList<Purchas> getPurchasesByUsername(String username) throws IOException {
	 
		String URL = "http://localhost:8000/api/purchases/by_user/"+username;
		 RestTemplate restTemplate = new RestTemplate();
		 
		ArrayList<Purchas> purchasesByUsername =
				restTemplate.getForObject(URL,HelperPurchasClass.class)
				.getPurchases();
		 

		return getFiveRecentPurchases(purchasesByUsername);
	}
  
	private ArrayList<Purchas> getFiveRecentPurchases(ArrayList<Purchas> listpurchase) {

		ArrayList<Purchas> recentFive = new ArrayList<>();

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
	private ArrayList<Purchas>  purchases; 
	
	ArrayList<Purchas> getPurchases() {
		return purchases;
	}
	
}