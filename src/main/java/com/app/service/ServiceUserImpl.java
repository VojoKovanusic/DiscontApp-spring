package com.app.service;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.entity.User;
import com.app.scraping.ScrapingImpl;

@Service
public class ServiceUserImpl implements ServiceUser {

	@Autowired
	private ScrapingImpl scraping;

	@Override
	public ArrayList<User> getUsers() {

		ArrayList<User> usersList =  getFromJsonUsers();
		return usersList;
	}

	private ArrayList<User> getFromJsonUsers() {

		ArrayList<User> usersList = new ArrayList<>();
		String textObj = scraping.getTextUsers();
		JSONObject obj;

		try {
			obj = new JSONObject(textObj);
			org.json.JSONArray users = obj.getJSONArray("users");

			for (int i = 0; i < users.length(); ++i) {
				JSONObject jsonObj = users.getJSONObject(i);

				String username = jsonObj.getString("username");
				String email = jsonObj.getString("email");
				usersList.add(new User(username, email));
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return usersList;
	}

	@Override
	public List<String> getUserName() {
		List<String> names = new ArrayList<>();

		for (User user : getUsers()) {
			names.add(user.getUsername());
		}
		return names;
	}
}
