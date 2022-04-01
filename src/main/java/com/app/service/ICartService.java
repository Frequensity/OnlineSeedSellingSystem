package com.app.service;

import java.util.List;

import com.app.pojos.Cart;

public interface ICartService {
	
	Cart addCart(Cart transientCart);
	
	List<Cart> getUserItems(int id);
	
	String deleteCartItems(int id);
	
}
