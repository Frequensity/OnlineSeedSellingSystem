package com.app.service;

import com.app.pojos.Catagory;

public interface ICatagoryService {
	Catagory addCatagory(Catagory transientCatagory);
	
	Catagory getCatagoryById(int id);
	
	void deleteCatagory(int id);
}