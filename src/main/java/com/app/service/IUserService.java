package com.app.service;

import java.util.List;

import com.app.dto.LoginRequest;
import com.app.pojos.User;

public interface IUserService {
	
	User addUser(User transientUser);
	
	User getUserDetails(int id);
	
	String deleteUser(int id);
	
	User authenticateUserLogin(LoginRequest loginRequst);
	
	List<User> getAllUSer();
}
