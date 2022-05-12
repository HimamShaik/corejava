package com.him.Hotel_Reservation.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.him.Hotel_Reservation.entity.Admin;
import com.him.Hotel_Reservation.entity.Employee;
import com.him.Hotel_Reservation.entity.Response;
import com.him.Hotel_Reservation.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;

	Response response = new Response();

	Logger log = Logger.getLogger(EmployeeController.class.getName());

	@PostMapping("/addEmployee")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
		service.addingEmployee(employee);
		log.info("admin data is adding via calling service method");
		response.setStatusCode(601);
		response.setMessage("hey " + employee.getName() + " your data is added successfully");
		return new ResponseEntity<Object>(response, HttpStatus.CREATED);
	}

	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Object> getEmployee(@PathVariable int id) {
		log.info("processing the data passing through the service layer");
		Employee emp = service.getEmployee(id);
		return new ResponseEntity<Object>(emp, HttpStatus.FOUND);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable int id) {
		log.info("processing the data passing through the service layer");
		service.delEmployee(id);
		response.setStatusCode(602);
		response.setMessage("hey admin " + id + " this data is deleted");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	@PutMapping("/updateEmployee")
	public ResponseEntity<Object> updateEmployees(@RequestBody Employee emp){
		log.info("processing the data passing through the service layer");
		Employee admin1 = service.updEmployee(emp);
		return new ResponseEntity<Object>(admin1, HttpStatus.OK);
	}
	@GetMapping("/getAllEmployee")
	public ResponseEntity getAllEmployee(){
		List<Employee> emp=service.getAllEmp();
		return new ResponseEntity(emp, HttpStatus.OK);
	}

}
