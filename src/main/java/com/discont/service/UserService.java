package com.discont.service;

import java.util.List;

import com.discont.entity.User;

public interface UserService {

	List<User> getUsers();

	List<String> getUserNames();

	void addUser(User user);

}
