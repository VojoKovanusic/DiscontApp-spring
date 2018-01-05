package com.app.scraping;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.entity.Product;
import com.app.service.ServiceUser;

@Component
public class ScrapingImpl implements ScrapingInterface {
	@Autowired
	private ServiceUser serviceUser;

	@Override
	public List<Product> getAllProducts() {
		List<Product> listOfProducts = new ArrayList<>();

		String textObj = getTextProducts();
		JSONObject obj;
		try {
			obj = new JSONObject(textObj);
			org.json.JSONArray products = obj.getJSONArray("products");

			for (int i = 0; i < products.length(); ++i) {
				JSONObject jsonObj = products.getJSONObject(i);
				int id = jsonObj.getInt("id");
				String face = jsonObj.getString("face");
				double price = jsonObj.getDouble("price");
				int size = jsonObj.getInt("size");

				listOfProducts.add(new Product(id, face, price, size));

			}
		} catch (Exception e) {
			e.getMessage();
		}

		return listOfProducts;
	}

	@Override
	public String getTextUsers() {
		String result = "";
		String addres = "http://localhost:8000/api/users";
		URL pageLoc;
		try {
			pageLoc = new URL(addres);
			Scanner scaner = new Scanner(pageLoc.openStream());

			while (scaner.hasNext())
				result += scaner.next();
			scaner.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return result;
	}

	@Override
	public String getTextProducts() {
		String result = "";
		String addres = "http://localhost:8000/api/products";
		URL pageLoc;
		try {
			pageLoc = new URL(addres);
			Scanner scaner = new Scanner(pageLoc.openStream());

			while (scaner.hasNext())
				result += scaner.next();
			scaner.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return result;
	}

	@Override
	public String getTextPurchasesByUser() {
		String result = "";
		ArrayList<String> username = (ArrayList<String>) serviceUser.getUserName();
		for (int i = 0; i < username.size(); i++) {

			String addres = "http://localhost:8000/api/purchases/by_user/" + username.get(i);
			URL pageLoc;
			try {
				pageLoc = new URL(addres);
				Scanner scaner = new Scanner(pageLoc.openStream());

				while (scaner.hasNext())
					result += scaner.next();
				scaner.close();
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return result;

	}

}