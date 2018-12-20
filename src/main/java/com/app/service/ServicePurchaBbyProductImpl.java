package com.app.service;

import java.io.IOException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.app.entity.Purchase;

@Service
public class ServicePurchaBbyProductImpl implements ServicePurchaseByProduct {

	@Autowired
	private ServicePurchaseByUser servicePurchasesByUser;

	@Override
	@Cacheable(value = "ppp", key = "#productId")
	public ArrayList<Purchase> peopleWhoPreviouslyPurchasedProduct(int productId) {

		ArrayList<Purchase> purchase = new ArrayList<>();

		try {
			for (Purchase purchas : servicePurchasesByUser.getAllPurchases()) {
				if (purchas.getProductId() == (productId)) {
					purchase.add(purchas);
				}
			}
		} catch (IOException e) {

		}

		return purchase;
	}

	@CacheEvict(value = "ppp", key = "#productId")
	public void cacheEvict(String productId) {

	}
}
