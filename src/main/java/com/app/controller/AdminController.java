package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Catagory;
import com.app.service.CatagoryServiceImpl;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
	
	@Autowired
	private CatagoryServiceImpl catagoryService;
	
	public AdminController() {
		System.out.println("In Admin Controller "+getClass());
	}
	
	@PostMapping("/add")
	public Catagory addCatagory(@RequestBody Catagory c) {
		System.out.println("in add catagory ");
		
		return catagoryService.addCatagory(c);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCatagory(@PathVariable int id){
		System.out.println("in get catagory details");
		
		return new ResponseEntity<>(catagoryService.getCatagoryById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	
	
	
}
