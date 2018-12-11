package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.entity.Product;

import com.fasterxml.jackson.annotation.JsonProperty;

@Service
public class ServiceProductsImpl implements ServiceProducts {

	final private String path = "http://localhost:8000/api/products";
	
	@Override
	public List<Product> getAllProducts() {


		RestTemplate restTemplate = new RestTemplate();

		List<Product> products = 
				restTemplate.getForObject(path, HelperProductsClass.class)
				.getProducts();

		return products;
	}

	@Override
	@Cacheable(value = "product", key = "#id")
	public Product getProductById(int id) {
		Product product =  
				getAllProducts().stream()
				.filter(user -> user.getId() == id)
				.findFirst().orElse(null);
		 
				return product;
	 
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
	public void updateProduct(Long id,Product product) {
		Product productForModification=findProduct(id);
		 setFacePriceSize( product, productForModification); 
	}

	private void setFacePriceSize(Product product, Product productForModification) {
		productForModification.setFace(product.getFace());
		productForModification.setPrice(product.getPrice());
		productForModification.setSize(product.getSize());
		 
	}

	private Product findProduct(Long id ) {
		Product modifiedProduct = 
				getAllProducts().stream()
				.filter(p -> p.getId().equals(id)).findFirst()
				.orElse(null);
		 
		return modifiedProduct;
	}

	@Override
	public boolean deleteProduct(Long id) {
		Product product =findProduct(id);
		
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