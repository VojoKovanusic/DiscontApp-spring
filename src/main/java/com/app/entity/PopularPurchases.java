package com.app.entity;

import java.util.ArrayList;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@ToString
@RequiredArgsConstructor 
@Getter
@Setter
public class PopularPurchases implements Comparable<PopularPurchases> {
	@NonNull
    Product product;
	private ArrayList<String> recentUserNames= new ArrayList<>();
 
	@Override
	public int compareTo(PopularPurchases popularPurchases) {
		Integer recent = getRecentUserNames().size();
		Integer recentNew = popularPurchases.getRecentUserNames().size();
		return recentNew.compareTo(recent);
	}


	


 

}
