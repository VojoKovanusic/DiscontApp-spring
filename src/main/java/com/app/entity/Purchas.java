package com.app.entity;

public class Purchas implements Comparable<Purchas> {

	private Long purchasId;
	private String username;
	private long productId;
	private String date;

	public Purchas(long id, String username, long productId, String date) {
		this.purchasId = id;
		this.username = username;
		this.productId = productId;
		this.date = date;
	}
	

	public Purchas() {
	}

	public long getId() {
		return purchasId;
	}

	public void setId(long id) {
		this.purchasId = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public int compareTo(Purchas o) {

		return o.getDate().compareTo(getDate());
	}

	@Override
	public String toString() {
		return "Purchas [id=" + purchasId + ", username=" + username + ", productId=" + productId + ", date=" + date + "]";
	}

}
