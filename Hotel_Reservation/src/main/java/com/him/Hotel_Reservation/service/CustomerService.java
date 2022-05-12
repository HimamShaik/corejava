package com.him.Hotel_Reservation.service;

import java.util.List;

import com.him.Hotel_Reservation.entity.Customer;
import com.him.Hotel_Reservation.model.CustomerModel;

public interface CustomerService {

	 public Customer addCust(Customer customer);
	
	//public Customer addCust(CustomerModel customer);
	
	public Customer getCust(int id);
	
	public Customer updCust(CustomerModel model);
	
	public Customer customerLogin(String username,String password);

}
