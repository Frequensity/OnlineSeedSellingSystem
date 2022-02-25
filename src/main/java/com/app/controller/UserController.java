package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginRequest;
import com.app.pojos.Address;
import com.app.pojos.User;
import com.app.service.AddressServiceImpl;
import com.app.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired 
	private UserServiceImpl userService;
	
	@Autowired
	private AddressServiceImpl addressService;
	
	public UserController() {
		System.out.println("in user controller "+getClass());
	}
	
	@GetMapping("/home")
	public String showHomePage() {
		
		return "Hello, welcome to seed selling home page!!!";
	}
	
	// adding method to add a new user in system
	@PostMapping("/add")
	public User addUserDetails(@RequestBody User u) {
		System.out.println("in add user ");
		return userService.addUser(u);
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserDetails(@PathVariable int id) {
		System.out.println("in get user details "+id);
		
		
		return ResponseEntity.ok(userService.getUserDetails(id));
	}
	
	@PostMapping("/address/{id}")
	public Address addAddressToUser(@RequestBody Address a ,@PathVariable int id) {
		System.out.println("for assigning Address to user");
		
		return addressService.assignUserAddress(id, a);
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest request){
		System.out.println("in user authentication "+request);
		
		User user = userService.authenticateUserLogin(request);
		System.out.println("User "+user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	
}