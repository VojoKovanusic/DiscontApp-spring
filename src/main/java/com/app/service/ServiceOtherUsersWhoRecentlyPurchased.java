package com.app.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.stereotype.Service;

import com.app.entity.PopularPurchases;

@Service
public class ServiceOtherUsersWhoRecentlyPurchased {

	@Autowired
	private ServicePopularPurchases popularService;

	@Cacheable(value = "popularP", key = "#username")
	public ArrayList<PopularPurchases> usersWhoRecentlyPurchased(String username) {

		ArrayList<PopularPurchases> buySameProduct = new ArrayList<>();

		for (PopularPurchases popularPurchases : popularService.listOfPopularPurchases()) {

			//if there is already a username which bought, I delete it from the list  
			if (isContainsUsername(popularPurchases.getRecentUserNames(), username)) {
				popularPurchases.getRecentUserNames().remove(username);
				
				buySameProduct.add((popularPurchases));
			}
		}
		return buySameProduct;

	}

	private boolean isContainsUsername(ArrayList<String> allUsernames, String username) {

		for (String name : allUsernames) {
			if (name.equals(username))
				return true;
		}
		return false;
	}

	@CacheEvict(value = "popularP", key = "#username")
	public void evict(String username) {

	}
}
