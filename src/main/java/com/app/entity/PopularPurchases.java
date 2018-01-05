package com.app.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class PopularPurchases implements Comparable<PopularPurchases>, Serializable {
 
	private static final long serialVersionUID = 1L;
	private Product product;
	private ArrayList<String> recentUserNames;

	
	public PopularPurchases(Product product) {
	this.product = product;
	recentUserNames=new ArrayList<>();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ArrayList<String> getRecentUserNames() {
		return recentUserNames;
	}

	public void setRecentUserNames(ArrayList<String> recentUserNames) {
		this.recentUserNames = recentUserNames;
	}

	@Override
	public int compareTo(PopularPurchases o) {
		Integer recent = getRecentUserNames().size();
		Integer recentNew = o.getRecentUserNames().size();
		return recentNew.compareTo(recent);
	}

	@Override
	public String toString() {
		return "PopularPurchases [product=" + product + ", recentUserNames=" + recentUserNames + "]";
	}

}
