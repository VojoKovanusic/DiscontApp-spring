package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.app.entity.Product;
import com.app.json.JavaToJson;
import com.app.scraping.ScrapingImpl;

@Service
public class ServiceProductsImpl implements ServiceProducts {

	@Autowired
	private ScrapingImpl scraping;

	@Override
	@Cacheable(value = "product", key = "#id")
	public String getProduct(int id) {

		System.out.println("*************Test cache*******getProduct(int id)");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}

		for (Product product : scraping.getAllProducts()) {
			if (product.getId() == id)
				
				return JavaToJson.convertJavaToJSON(product);
		}
		return "Product with id'{{" + id + "}}' was not found";
	}

	@CacheEvict(value = "product", key = "#id")
	public void cacheProductEvict(int id) {
	}
}