package com.app.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Catagory;
import com.app.pojos.Product;
import com.app.service.CatagoryServiceImpl;
import com.app.service.ProductServiceImpl;

@RestController
@RequestMapping("/image")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
	
	@Value("${file.upload-dir}")
	private String FILE;
	
	@Autowired
	private ProductServiceImpl productService;
	
	@Autowired
	private CatagoryServiceImpl catagoryService;
	
	@PostMapping("/upload")
	public ResponseEntity<?> addProduct(@RequestParam MultipartFile file,
			@RequestParam String prodName,
			@RequestParam String descp,
			@RequestParam double price,
			@RequestParam int qty,
			@RequestParam int catId) throws IOException{
		System.out.println("in add product");
		File imageFile = new File(FILE+file.getOriginalFilename());
		imageFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(imageFile);
		fos.write(file.getBytes());
		fos.close();
		
		Catagory catagoryExist = catagoryService.getCatagoryById(catId);

		if(catagoryExist != null) {
			
			Product newProduct = new Product(file.getOriginalFilename(), prodName, descp, price, qty);
			newProduct.setCatagoryId(catagoryExist);
			productService.addproduct(newProduct);
			
			return new ResponseEntity<>(HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		

		
	}
}
