package com.app.service;

import com.app.dto.LoginRequest;
import com.app.pojos.User;

public interface IUserService {
	
	User addUser(User transientUser);
	
	User getUserDetails(int id);
	
	User authenticateUserLogin(LoginRequest loginRequst);
}
