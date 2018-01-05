package com.app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.app.entity.Purchas;
import com.app.json.JavaToJson;

@Service
public class ServicePurchaBbyProductImpl implements ServicePurchaBbyProduct {

	@Autowired
	private ServicePurchasesByUser servicePurchasesByUser;

	@Override
	@Cacheable(value = "ppp", key = "#productId")
	public List<String> peopleWhoPreviouslyPurchasedProduct(int productId) {
		System.out.println("*************Test cache*******peopleWhoPreviouslyPurchasedProduct(int productId)");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}		
		ArrayList<Purchas> purchase = new ArrayList<>();

			try {
				for (Purchas purchas : servicePurchasesByUser.getAllPurchases()) {

					if (purchas.getProductId() == (productId)) {
						purchase.add(purchas);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return convertJavaObjectToJson(purchase);
	}
	private ArrayList<String> convertJavaObjectToJson(ArrayList<Purchas> purchase) {
		ArrayList<String> jsonList = new ArrayList<>();
		for (Purchas purchas : purchase) {
			String jsonFormat = JavaToJson.convertJavaToJSON(purchas);
			jsonList.add(jsonFormat);
		}
		return jsonList;
	}
	

	@CacheEvict(value = "ppp", key = "#productId")
	public void cacheEvict(String productId) {

	}
}
