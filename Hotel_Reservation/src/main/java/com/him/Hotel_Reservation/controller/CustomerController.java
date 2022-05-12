package com.him.Hotel_Reservation.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.him.Hotel_Reservation.entity.Customer;
import com.him.Hotel_Reservation.entity.Response;
import com.him.Hotel_Reservation.model.CustomerModel;
import com.him.Hotel_Reservation.service.CustomerService;
import com.him.Hotel_Reservation.service.CustomerServiceImpl;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService service;
	Logger log = Logger.getLogger(CustomerController.class.getName());

	Response response = new Response();

	@PostMapping("/addCustomer")
	public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {
		Customer custmer = service.addCust(customer);
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("data successfully added");
		return new ResponseEntity<Object>(response, HttpStatus.CREATED);
	}

//	@PostMapping("/addCustomer")
//	public ResponseEntity<Object> addCustomer(@RequestBody CustomerModel customer) {
//		log.debug("processing the data to the controller to service");
//		Customer addingcust = service.addCust(customer);
//		return new ResponseEntity<Object>(addingcust, HttpStatus.CREATED);
//	}
	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<Object> getCustomer(@PathVariable int id) {
		log.debug("processing the fetching data to the controller to service");
		Customer cust = service.getCust(id);
		return new ResponseEntity<Object>(cust, HttpStatus.FOUND);
	}

	@PutMapping("/updateCustomer")
	public ResponseEntity<Object> updateCustomer(@RequestBody CustomerModel model) {
		Customer custe = service.updCust(model);
		return new ResponseEntity<Object>(custe, HttpStatus.ACCEPTED);
	}
//
//	@PutMapping("/customerLogin/{username}/{password}")
//	public ResponseEntity<Object> checkCustomerCredentials(@PathVariable String username,
//			@PathVariable String password) {
//
//	}
}
