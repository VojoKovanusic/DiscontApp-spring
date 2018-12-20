package com.discont.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString

@Data
@NoArgsConstructor
public class Product  {

	private Long id;
	private String face;
	private double price;
	private int size;

	
}
