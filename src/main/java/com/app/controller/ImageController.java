package com.app.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
@CrossOrigin("*")
public class ImageController {
	
	@Value("${file.upload-dir}")
	private String FILE;
	
	@PostMapping("/upload")
	public ResponseEntity<Object> imageUpload(@RequestParam("File") MultipartFile file) throws IOException{
		
		File imageFile = new File(FILE+file.getOriginalFilename());
		imageFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(imageFile);
		fos.write(file.getBytes());
		fos.close();
		
		return new ResponseEntity<Object>(file.getOriginalFilename(),HttpStatus.OK);
	}
}
