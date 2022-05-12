package com.him.Hotel_Reservation.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.him.Hotel_Reservation.entity.Customer;
import com.him.Hotel_Reservation.exception.ResourceAllreadyExists;
import com.him.Hotel_Reservation.exception.ResourseNotFound;
import com.him.Hotel_Reservation.model.CustomerModel;
import com.him.Hotel_Reservation.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo repo;
	Logger log = Logger.getLogger(CustomerServiceImpl.class.getName());
	Customer csmr = new Customer();

//	@Override
//	public Customer addCust(CustomerModel customer) {
//		Optional<Customer> cust = repo.findBycustName(customer.getCustName());
//		if (cust.isPresent()) {
//			log.info("data is allready present with this " + customer.getCustName() + " name");
//			throw new ResourceAllreadyExists(
//					"data is allready present with this " + customer.getCustName() + " plse try with different name");
//		} else {
//			log.debug("inserting data into database : from service layer");
//			csmr.setCustId(customer.getCustId());
//			csmr.setCustName(customer.getCustName());
//			csmr.setCustomerAge(customer.getCustomerAge());
//			csmr.setPhoneNo(customer.getPhoneNo());
//			csmr.setCustPassword(customer.getCustPassword());
//			csmr.setUserName(customer.getUserName());
//			repo.save(csmr);
//			return csmr;
//
//		}
//	}

	@Override
	public Customer getCust(int id) {
		Optional<Customer> cust = repo.findById(id);
		if (cust.isPresent()) {
			log.info("customer data found in database : from service layer");
			return cust.get();
		} else {
			log.warn("customer data is not found in database");
			throw new ResourseNotFound("hey customer your data is not present");
		}
	}

	@Override
	public Customer updCust(CustomerModel model) {
		Optional<Customer> cust = repo.findById(model.getCustId());
		if (cust.isPresent()) {
			Customer custe = cust.get();
			csmr.setCustId(model.getCustId());
			csmr.setCustName(model.getCustName());
			csmr.setUserName(model.getUserName());
			csmr.setCustomerAge(model.getCustomerAge());
			csmr.setPhoneNo(model.getPhoneNo());
			csmr.setCustPassword(model.getCustPassword());
			Customer csmr1 = repo.save(csmr);
			return csmr1;

		} else {
			log.warn("there is no data upon this user id : from service layer");
			throw new ResourseNotFound("there is no data upon this user id : from service layer" + model.getCustName());
		}
	}

	@Override
	public Customer addCust(Customer customer) {
		Optional<Customer> cust = repo.findBycustName(customer.getCustName());
		if (cust.isPresent()) {
			log.info("data is allready present with this " + customer.getCustName() + " name");
			throw new ResourceAllreadyExists(
					"data is allready present with this " + customer.getCustName() + " plse try with different name");
		} else {
			log.debug("inserting data into database : from service layer");
			Customer custmer = repo.save(customer);
			return custmer;
		}

	}

	@Override
	public Customer customerLogin(String username, String password) {
		Optional<Customer> custmer=repo.findBycustName(username);
		return null;
	}

}
