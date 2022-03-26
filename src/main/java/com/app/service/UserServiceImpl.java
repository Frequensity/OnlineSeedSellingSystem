package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptiom.AssetNotFoundException;
import com.app.dao.UserRepository;
import com.app.dto.LoginRequest;
import com.app.pojos.Role;
import com.app.pojos.User;


@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User addUser(User transientUser) {
		//it will return saved user
		return userRepository.save(transientUser);
	}

	@Override
	public User getUserDetails(int id) {
		
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(()-> new RuntimeException("User not found by "+id));
		
	}

	@Override
	public User authenticateUserLogin(LoginRequest loginRequst) {
		
		return userRepository.validateUser(loginRequst.getEmail(), loginRequst.getPassword())
							 .orElseThrow(()-> new AssetNotFoundException("User Not found "));
	}

	@Override
	public List<User> getAllUSer() {
		
		return userRepository.findByType(Role.USER);
	}

	@Override
	public String deleteUser(int id) {
		userRepository.deleteById(id);
		return "User deleted successfully";
	}

	
	
	
	

	
	
	

}
