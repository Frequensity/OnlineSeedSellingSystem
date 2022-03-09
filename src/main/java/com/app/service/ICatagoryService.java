package com.app.service;

import java.util.List;

import com.app.pojos.Catagory;

public interface ICatagoryService {
	Catagory addCatagory(Catagory transientCatagory);
	
	Catagory getCatagoryById(int id);
	
	void deleteCatagory(int id);
	
	List<Catagory> getAllCatagories();
}
