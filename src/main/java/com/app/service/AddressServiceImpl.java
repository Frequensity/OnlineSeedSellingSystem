package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AddressRepository;
import com.app.dao.UserRepository;
import com.app.pojos.Address;
import com.app.pojos.User;
@Service
@Transactional
public class AddressServiceImpl implements IAddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public Address assignUserAddress(int uid,Address transientAddress) {
		User user = userRepo.findById(uid).orElseThrow(()-> new RuntimeException("User not found "));
		transientAddress.setUser(user);
		
		return addressRepository.save(transientAddress);
	}
	
	

}
