package com.discont.entity;

import java.util.ArrayList;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
@Data
public class PopularPurchase {
	@NonNull
	Product product;
	private ArrayList<String> recentUserNames = new ArrayList<>();

}
