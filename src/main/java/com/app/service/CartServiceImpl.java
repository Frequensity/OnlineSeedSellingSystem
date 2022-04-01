package com.app.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CartRepository;
import com.app.pojos.Cart;

@Service
@Transactional
public class CartServiceImpl implements ICartService {

	@Autowired
	private CartRepository cartRepo;
	
	@Override
	public Cart addCart(Cart transientCart) {
		
		return cartRepo.save(transientCart);
	}

	@Override
	public List<Cart> getUserItems(int id) {
		return cartRepo.findCartByUserId(id);
	}

	@Override
	public String deleteCartItems(int id) {
		cartRepo.deleteById(id);
		return "product deleted Successfully";
	}

	

}
