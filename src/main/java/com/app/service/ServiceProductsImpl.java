package com.app.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.entity.Product;

import com.fasterxml.jackson.annotation.JsonProperty;

@Service
public class ServiceProductsImpl implements ServiceProducts {

	@Override
	public List<Product> getAllProducts() {

		final String path = "http://localhost:8000/api/products";

		RestTemplate restTemplate = new RestTemplate();

		List<Product> products = restTemplate.getForObject(path, HelperProductsClass.class).getProducts();

		return products;
	}

	@Override
	@Cacheable(value = "product", key = "#id")
	public Product getProductById(int id) {

		for (Product product : getAllProducts()) {
			if (product.getId() == id)
				return product;
		}
		return null;
	}

	@CacheEvict(value = "product", key = "#id")
	public void cacheProductEvict(int id) {
	}

	@Override
	public void addProduct(Product product) {
		long id = getAllProducts().size() + 1;
		product.setId(id);
		getAllProducts().add(product);

	}

	@Override
	public void remove(Product product) {
		getAllProducts().remove(product);

	}

	@Override
	public void updateProduct(Product product) {

		Product modifiedProduct = getAllProducts().stream().filter(p -> p.getId() == product.getId()).findFirst()
				.orElse(null);
		modifiedProduct.setFace(product.getFace());
		modifiedProduct.setPrice(product.getPrice());
		modifiedProduct.setSize(product.getSize());

	}

	@Override
	public boolean deleteProduct(Long id) {
		Product product =  getAllProducts()
				.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
		if (product != null) {
			 remove(product);
			
		 return true;
		}
		return false;
	}

}

class HelperProductsClass {

	@JsonProperty("products")
	private List<Product> products;

	List<Product> getProducts() {
		return products;
	}

}