package com.app.service;

import java.util.Optional;

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

	@Override
	public Catagory getCatagoryById(int id) {
		 Optional<Catagory> catagory = catagoryRepo.findById(id);
		return catagory.orElseThrow(()-> new RuntimeException("catagory not found by id "+id));
	}

	@Override
	public void deleteCatagory(int id) {
		 catagoryRepo.deleteById(id);
		 
	}

	
	

}
