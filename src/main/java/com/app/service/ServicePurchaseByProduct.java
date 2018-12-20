package com.app.service;

import java.util.ArrayList;

import com.app.entity.Purchase;

public interface ServicePurchaseByProduct {

	ArrayList<Purchase> peopleWhoPreviouslyPurchasedProduct(int productId);

}
