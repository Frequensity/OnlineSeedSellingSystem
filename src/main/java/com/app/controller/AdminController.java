package com.app.controller;

import java.util.List;

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

import com.app.dto.ResponseDTO;
import com.app.pojos.Catagory;
import com.app.pojos.Product;
import com.app.service.CatagoryServiceImpl;
import com.app.service.ProductServiceImpl;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
	
	@Autowired
	private CatagoryServiceImpl catagoryService;
	
	@Autowired
	private ProductServiceImpl productService;
	
	public AdminController() {
		System.out.println("In Admin Controller "+getClass());
	}
	
	@PostMapping("/addCatagory")
	public ResponseDTO<?> addCatagory(@RequestBody Catagory c) {
		System.out.println("in add catagory ");
		Catagory newCatagory = catagoryService.addCatagory(c);
		return new ResponseDTO<>(HttpStatus.OK,"Catagory Added Successfully ",newCatagory);
	}
	
	@GetMapping("/catagory/{id}")
	public ResponseEntity<?> getCatagory(@PathVariable int id){
		System.out.println("in get catagory details");
		
		return new ResponseEntity<>(catagoryService.getCatagoryById(id),HttpStatus.OK);
	}
	
	@GetMapping("/getCatagory")
	public ResponseDTO<?> getAllCatagoryList(){
		List<Catagory> allCatagories = catagoryService.getAllCatagories();
		return new ResponseDTO<>(HttpStatus.OK, "All Catagories", allCatagories);
	}
	
	@GetMapping("/getProduct")
	public ResponseDTO<?> getAllProductList(){
		List<Product> allProducts = productService.getAllProducts();
		
		return new ResponseDTO<>(HttpStatus.OK,"product are received",allProducts);
	}
	
	
	
}
