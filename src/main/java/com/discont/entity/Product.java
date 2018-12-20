package com.discont.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter @Setter
@NoArgsConstructor
public class Product  {

	private Long id;
	private String face;
	private double price;
	private int size;

	
}
