
package com.discont.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.discont.entity.PopularPurchase;
import com.discont.entity.Product;
import com.discont.entity.Purchase;

@Service
public class PopularPurchaseServiceImpl implements PopularPurchaseService {

	private PurchaseService userService;

	private ProductService serviceProducts;

	@Autowired
	public PopularPurchaseServiceImpl(PurchaseService userService, ProductService serviceProducts) {
		this.userService = userService;
		this.serviceProducts = serviceProducts;
	}

	@Override
	@Cacheable("popular")
	public ArrayList<PopularPurchase> getPopularPurchases() {

		ArrayList<PopularPurchase> popularPurchases = new ArrayList<>();

		fillPopularPurchasesWhithProducts(popularPurchases);

		addUserNameInPopularPurchases(popularPurchases);

		sortPopularPurchases(popularPurchases);

		return popularPurchases;
	}

	private void addUserNameInPopularPurchases(ArrayList<PopularPurchase> popularList) {
		popularList.forEach(popularPurchase -> addUserNameInPopularPurchas(popularPurchase));

	}

	private void addUserNameInPopularPurchas(PopularPurchase popularPurchase) {
		userService.getAllPurchases().stream()
				.filter(purchas -> popularPurchase.getProduct().getId() == (purchas.getProductId()))
				.forEach((purchas) -> {
					popularPurchase.getRecentUserNames().add(purchas.getUsername());
				});
	}

	private void sortPopularPurchases(ArrayList<PopularPurchase> popularList) {
		Collections.sort(popularList, (o1, o2) -> {
			return Integer.compare(o2.getRecentUserNames().size(), o1.getRecentUserNames().size());
		});
	}

	private void fillPopularPurchasesWhithProducts(ArrayList<PopularPurchase> popularList) {
		for (Product product : serviceProducts.getAllProducts()) {
			popularList.add(new PopularPurchase(product));
		}
	}

	@Cacheable(value = "popularP", key = "#username")
	public ArrayList<PopularPurchase> usersWhoRecentlyPurchased(String username) {

		ArrayList<PopularPurchase> buySameProduct = new ArrayList<>();

		for (PopularPurchase popularPurchases : getPopularPurchases()) {

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

	@CacheEvict("popular")
	public void cacheEvict() {

	}
}
