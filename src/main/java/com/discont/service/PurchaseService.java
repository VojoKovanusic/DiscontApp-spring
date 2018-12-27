package com.discont.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.discont.entity.Purchase;

public interface PurchaseService {

	 ArrayList<Purchase> getPurchasesByUsername(String username) throws IOException;

	 List<Purchase> getAllPurchases() ;
	 
	List<Purchase> peopleWhoPreviouslyPurchasedProduct(int productId)throws IOException;

	 
}
