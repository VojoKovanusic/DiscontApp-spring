package com.app.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import com.app.entity.PopularPurchases;
import com.app.json.JavaToJson;

@Component
public class ServiceOtherUsersWhoRecentlyPurchased {

	@Autowired
	private ServicePopularPurchases popularService;

	@Cacheable(value = "popularP", key = "#username")
	public ArrayList<String> usersWhoRecentlyPurchased(String username) {
		System.out.println("*************Test cache*******usersWhoRecentlyPurchased");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		ArrayList<PopularPurchases> all = popularService.popular();

		ArrayList<String> sameProduct = new ArrayList<>();

		for (PopularPurchases objFromAll : all) {

			if (isContainsUsername(objFromAll.getRecentUserNames(), username)) {
				objFromAll.getRecentUserNames().remove(username);
				
				sameProduct.add(JavaToJson.convertJavaToJSON(objFromAll));
			}
		}
		return sameProduct;

	}

	private boolean isContainsUsername(ArrayList<String> names, String username) {

		for (String name : names) {
			if (name.equals(username))
				return true;
		}
		return false;
	}

	@CacheEvict(value = "popularP", key = "#username")
	public void evict(String username) {

	}
}
