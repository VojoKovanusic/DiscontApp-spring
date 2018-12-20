package com.discont.service;

import java.util.ArrayList;

import com.discont.entity.Purchase;

public interface ServicePurchaseByProduct {

	ArrayList<Purchase> peopleWhoPreviouslyPurchasedProduct(int productId);

}
