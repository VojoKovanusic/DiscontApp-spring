package com.app.service;

import java.util.ArrayList;

import com.app.entity.Purchas;
 

public interface ServicePurchaseByProduct {

	ArrayList<Purchas>  peopleWhoPreviouslyPurchasedProduct(int productId);

}
