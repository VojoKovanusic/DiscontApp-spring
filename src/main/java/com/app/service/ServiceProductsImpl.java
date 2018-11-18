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
		 
		 final String uri = "http://localhost:8000/api/products";
	     
		    RestTemplate restTemplate = new RestTemplate();
	 
			List<Product> products =
					restTemplate.getForObject(uri,HelperProductsClass.class)
					.getProducts();
		     
		     return products ;
		}
	
	
	@Override
	@Cacheable(value = "product", key = "#id")
	public String getProductById(int id) {

		for (Product product : getAllProducts()) {
			System.out.println("id: "+id);
			System.out.println("product.getId(): "+product.getId());
			if (product.getId() == id)
			
				return  product.toString() ;
		}
		return  null;
	}

	@CacheEvict(value = "product", key = "#id")
	public void cacheProductEvict(int id) {
	}


	 

	@Override
	public void addProduct(Product product) {
		long id= getAllProducts().size()+1;
		product.setId(id);
		getAllProducts().add(product);
		
	}

	@Override
	public void remove(Product product) {
		getAllProducts().remove(product);
		
	}

	@Override
	public void updateProduct(Product product) {
		
			Product modifiedProduct = getAllProducts().stream().filter(p -> p.getId() == product.getId()).findFirst().orElse(null);
			modifiedProduct.setFace(product.getFace()); 
			modifiedProduct.setPrice(product.getPrice()); 
			modifiedProduct.setSize(product.getSize());
			
				
			}
	
}

class HelperProductsClass {

	   @JsonProperty("products")
	   private List<Product> products; 
	   
	List<Product> getProducts() {
		return products;
	}

}