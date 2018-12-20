package com.app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.app.entity.Purchase;

public interface ServicePurchaseByUser {

	public ArrayList<Purchase> getPurchasesByUsername(String username) throws IOException;

	public List<Purchase> getAllPurchases() throws IOException;
}
