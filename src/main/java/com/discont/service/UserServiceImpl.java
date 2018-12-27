package com.discont.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.discont.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;

@Service
public class UserServiceImpl implements UserService {

	private RestTemplate restTemplate;

	@Value(("${rest.users.username}"))
	private String usersByUsernameUrl;

	@Autowired
	public UserServiceImpl(RestTemplate restTemplate) {

		this.restTemplate = restTemplate;
	}

	@Override 
	public List<User> getUsers() {

		List<User> users = 
				restTemplate.getForObject(usersByUsernameUrl, HelperUserClass.class)
				.getUsers();

		return users;

	}

	@Override
	public List<String> getUserNames() {

		List<String> names = new ArrayList<>();
	
		 getUsers().forEach
		 (user->
		 names.add(user.getUsername()));

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
