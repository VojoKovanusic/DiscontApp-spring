package com.discont.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.stereotype.Service;

import com.discont.entity.PopularPurchase;

@Service
public class ServiceUsersWhoRecentlyPurchased {

	@Autowired
	private ServicePopularPurchase popularService;

	@Cacheable(value = "popularP", key = "#username")
	public ArrayList<PopularPurchase> usersWhoRecentlyPurchased(String username) {

		ArrayList<PopularPurchase> buySameProduct = new ArrayList<>();

		for (PopularPurchase popularPurchases : popularService.listOfPopularPurchases()) {

			// if there is already a username which bought, I delete it from the list
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
