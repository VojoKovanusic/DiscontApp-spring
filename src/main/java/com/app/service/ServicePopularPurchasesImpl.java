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
import com.app.scraping.ScrapingInterface;

@Component
public class ServicePopularPurchasesImpl implements ServicePopularPurchases {

	@Autowired
	private ServicePurchasesByUser userService;
	@Autowired
	private ScrapingInterface scraping;

	@Override
	// @Cacheable("popular")
	public ArrayList<PopularPurchases> popular() {

		ArrayList<PopularPurchases> popularList = new ArrayList<>();

		for (Product product : scraping.getAllProducts()) {
			popularList.add(new PopularPurchases(product));
		}

		for (PopularPurchases popularPurchases : popularList) {
			try {
				for (Purchas purchas : userService.getAllPurchases()) {
					if (popularPurchases.getProduct().getId()==(purchas.getProductId()))
						popularPurchases.getRecentUserNames().add(purchas.getUsername());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		Collections.sort(popularList);
		return popularList;
	}

	private ArrayList<String> convertJavaObjectToJson(ArrayList<PopularPurchases> list) {
		ArrayList<String> jsonList = new ArrayList<>();
		for (PopularPurchases purchas : list) {
			String jsonFormat = JavaToJson.convertJavaToJSON(purchas);
			jsonList.add(jsonFormat);
		}
		return jsonList;
	}

	@Override
	@Cacheable("popular")
	public String popularJson() {
		ArrayList<PopularPurchases> popularJson = popular();
		return convertJavaObjectToJson(popularJson).toString();
	}

	@CacheEvict("popular")
	public void cacheEvictAccounts() {

	}
}
