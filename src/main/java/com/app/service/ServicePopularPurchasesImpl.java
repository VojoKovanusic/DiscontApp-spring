package com.app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import com.app.entity.PopularPurchases;
import com.app.entity.Product;
import com.app.entity.Purchas;
import com.app.json.JavaToJson;


@Component
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

		for (PopularPurchases popularPurchases : popularList) {
			
			try {
				for (Purchas purchas : userService.getAllPurchases()) {
					
					if (popularPurchases.getProduct().getId()==(purchas.getProductId()))
					{
						popularPurchases.getRecentUserNames()
						.add(purchas.getUsername());
					}
				}
				
			} catch (IOException e) {

			}
		}

		Collections.sort(popularList);
		return popularList;
	}

	private void fillPopularPurchasesListWhithProducts(ArrayList<PopularPurchases> popularList) {
		for (Product product : serviceProducts.getAllProducts()) {
			popularList.add(new PopularPurchases(product));
		}
	}
 
	@CacheEvict("popular")
	public void cacheEvictAccounts() {

	}
}
