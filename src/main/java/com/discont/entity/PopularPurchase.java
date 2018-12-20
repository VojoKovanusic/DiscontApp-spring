package com.discont.entity;

import java.util.ArrayList;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
@Getter @Setter
public class PopularPurchase {
	@NonNull
	Product product;
	private ArrayList<String> recentUserNames = new ArrayList<>();

}
