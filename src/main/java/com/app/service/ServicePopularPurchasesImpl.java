package com.app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.app.entity.PopularPurchases;
import com.app.entity.Product;
import com.app.entity.Purchas;

@Service
public class ServicePopularPurchasesImpl implements ServicePopularPurchases {

	@Autowired
	private ServicePurchasesByUser userService;
	@Autowired
	private ServiceProducts serviceProducts;

	@Override
	@Cacheable("popular")
	public ArrayList<PopularPurchases> listOfPopularPurchases() {

		ArrayList<PopularPurchases> popularList = new ArrayList<>();

		fillPopularPurchasesListWhithProducts(popularList);

		addUsernameInPopularPurchase(popularList);

		sortPopularPurchasesList(popularList);

		return popularList;
	}

	private void addUsernameInPopularPurchase(ArrayList<PopularPurchases> popularList) {
		for (PopularPurchases popularPurchase : popularList) {

			try {
				for (Purchas purchas : userService.getAllPurchases()) {

					if (popularPurchase.getProduct().getId() == (purchas.getProductId())) {
						popularPurchase.getRecentUserNames().add(purchas.getUsername());
					}
				}

			} catch (IOException e) {

			}
		}
	}

	private void sortPopularPurchasesList(ArrayList<PopularPurchases> popularList) {
		Collections.sort(popularList, (o1, o2) -> {
			return Integer.compare(o2.getRecentUserNames().size(), o1.getRecentUserNames().size());
		});
	}

	private void fillPopularPurchasesListWhithProducts(ArrayList<PopularPurchases> popularList) {
		for (Product product : serviceProducts.getAllProducts()) {
			popularList.add(new PopularPurchases(product));
		}
	}

	@CacheEvict("popular")
	public void cacheEvict() {

	}
}
