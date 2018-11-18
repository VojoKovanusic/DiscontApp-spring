package com.app.service;

import java.io.IOException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.app.entity.Purchas;


@Service
public class ServicePurchaBbyProductImpl implements ServicePurchaBbyProduct {

	@Autowired
	private ServicePurchasesByUser servicePurchasesByUser;

	@Override
	@Cacheable(value = "ppp", key = "#productId")
	public ArrayList<Purchas> peopleWhoPreviouslyPurchasedProduct(int productId) {

		ArrayList<Purchas> purchase = new ArrayList<>();

			try {
				for (Purchas purchas : servicePurchasesByUser.getAllPurchases()) {
					if (purchas.getProductId() == (productId)) {
						purchase.add(purchas);
					}
				}
			} catch (IOException e) {

			}
			 
			return  purchase  ;
	}
 

	@CacheEvict(value = "ppp", key = "#productId")
	public void cacheEvict(String productId) {

	}
}
