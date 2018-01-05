package com.app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import com.app.entity.Purchas;
 

public interface ServicePurchasesByUser {
	
	public ArrayList<Purchas> getFiveRecentPurchases(ArrayList<Purchas> list);	
	
	public ArrayList<String> getPurchasesByUsername(String username)throws IOException;
	
	public List<Purchas> getAllPurchases()throws IOException ;
}
