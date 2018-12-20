package com.discont.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@ToString
@NoArgsConstructor
@Getter @Setter
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
