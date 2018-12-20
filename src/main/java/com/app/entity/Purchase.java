package com.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@NoArgsConstructor
@Data
public class Purchase implements Comparable<Purchase> {

	private Long purchasId;
	private String username;
	private long productId;
	private String date;

  
	@Override
	public int compareTo(Purchase o) {

		return o.getDate().compareTo(getDate());
	}
 

}
