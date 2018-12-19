package com.app.service;

import java.util.List;
import com.app.entity.User;

public interface ServiceUser {


	List<User>  getUsers();
	List<String>  getUserName();
	void addUser(User user);
 
}
