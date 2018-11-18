package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;


@Service
public class ServiceUserImpl implements ServiceUser {

	@Override
	public ArrayList<User> getUsers() {

		final String uri = "http://localhost:8000/api/users";
	     
		    RestTemplate restTemplate = new RestTemplate();
	 
		    List<User> usersList =
					restTemplate.getForObject(uri,HelperUserClass.class)
					.getUsers();
		     
		     return (ArrayList<User>) usersList ;
		
	}


	@Override
	public List<String> getUserName() {
		
		List<String> names = new ArrayList<>();
		for (User user : getUsers()) {
			names.add(user.getUsername());
		}
		return names;
	}

	@Override
	public void addUser(User user) {
		getUsers().add(user); 
		
	}
	
}
class HelperUserClass {
	
	@JsonProperty("users")
	private List<User> users; 
	
	List<User> getUsers() {
		return users;
	}
	
}
