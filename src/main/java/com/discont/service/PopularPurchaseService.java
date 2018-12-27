package com.discont.service;

import java.util.ArrayList;

import com.discont.entity.PopularPurchase;

public interface PopularPurchaseService {
	
	ArrayList<PopularPurchase> getPopularPurchases();
	
	ArrayList<PopularPurchase> usersWhoRecentlyPurchased(String username);

}
