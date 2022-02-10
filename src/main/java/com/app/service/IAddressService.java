package com.app.service;

import com.app.pojos.Address;

public interface IAddressService {
	Address assignUserAddress(int uid,Address transientAddress);
}
