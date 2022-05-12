package com.him.Hotel_Reservation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.him.Hotel_Reservation.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	public Optional<Customer> findBycustName(String custname);
	
	public Optional<Customer> findById(int custId);
}
