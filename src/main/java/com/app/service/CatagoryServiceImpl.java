package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.dao.CatagoryRepository;
import com.app.pojos.Catagory;

public class CatagoryServiceImpl implements ICatagoryService {
	
	@Autowired
	private CatagoryRepository catagoryRepo;
	
	@Override
	public Catagory addCatagory(Catagory transientCatagory) {
		// it will return saved catagory
		return catagoryRepo.save(transientCatagory);
	}

}
