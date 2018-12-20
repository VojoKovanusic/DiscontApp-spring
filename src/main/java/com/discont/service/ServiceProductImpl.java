package com.discont.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.discont.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

@Service
public class ServiceProductImpl implements ServiceProducts {
	 
	private RestTemplate restTemplate;


	@Value("${rest.purchase.url.purchase.user}")
	private String purchaseByuserUrl;
	
	@Value("${rest.url.products}")
	private String productsUrl;
	
	
	@Autowired
	public ServiceProductImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public List<Product> getAllProducts() {

		List<Product> products = 
				restTemplate.getForObject(productsUrl, HelperProductsClass.class)
				.getProducts();

		return products;
	}

	@Override
	@Cacheable(value = "product", key = "#id")
	public Product getProductById(int id) {
		Product product = getAllProducts().stream().filter(user -> user.getId() == id).findFirst().orElse(null);

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
	public void updateProduct(Long id, Product product) {
		Product productForModification = findProduct(id);
		setFacePriceSize(product, productForModification);
	}

	private void setFacePriceSize(Product product, Product productForModification) {
		productForModification.setFace(product.getFace());
		productForModification.setPrice(product.getPrice());
		productForModification.setSize(product.getSize());

	}

	private Product findProduct(Long id) {
		Product modifiedProduct = getAllProducts().stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);

		return modifiedProduct;
	}

	@Override
	public boolean deleteProduct(Long id) {
		Product product = findProduct(id);

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