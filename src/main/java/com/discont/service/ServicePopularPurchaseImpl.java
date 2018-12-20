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
public class ServicePopularPurchaseImpl implements ServicePopularPurchase {

	@Autowired
	private ServicePurchaseByUser userService;
	@Autowired
	private ServiceProducts serviceProducts;

	@Override
	@Cacheable("popular")
	public ArrayList<PopularPurchase> listOfPopularPurchases() {

		ArrayList<PopularPurchase> popularList = new ArrayList<>();

		fillPopularPurchasesListWhithProducts(popularList);

		addUsernameInPopularPurchase(popularList);

		sortPopularPurchasesList(popularList);

		return popularList;
	}

	private void addUsernameInPopularPurchase(ArrayList<PopularPurchase> popularList) {
		for (PopularPurchase popularPurchase : popularList) {

			try {
				for (Purchase purchas : userService.getAllPurchases()) {

					if (popularPurchase.getProduct().getId() == (purchas.getProductId())) {
						popularPurchase.getRecentUserNames().add(purchas.getUsername());
					}
				}

			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}

	private void sortPopularPurchasesList(ArrayList<PopularPurchase> popularList) {
		Collections.sort(popularList, (o1, o2) -> {
			return Integer.compare(o2.getRecentUserNames().size(), o1.getRecentUserNames().size());
		});
	}

	private void fillPopularPurchasesListWhithProducts(ArrayList<PopularPurchase> popularList) {
		for (Product product : serviceProducts.getAllProducts()) {
			popularList.add(new PopularPurchase(product));
		}
	}

	@CacheEvict("popular")
	public void cacheEvict() {

	}
}
