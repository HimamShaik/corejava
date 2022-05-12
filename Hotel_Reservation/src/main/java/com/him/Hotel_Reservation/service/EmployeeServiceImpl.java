package com.him.Hotel_Reservation.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.him.Hotel_Reservation.entity.Admin;
import com.him.Hotel_Reservation.entity.Employee;
import com.him.Hotel_Reservation.exception.ResourceAllreadyExists;
import com.him.Hotel_Reservation.exception.ResourseNotFound;
import com.him.Hotel_Reservation.repo.EmployeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo repo;
	Logger log = Logger.getLogger(EmployeeServiceImpl.class.getName());

	@Override
	public Employee addingEmployee(Employee employee) {
		Optional<Employee> employe = repo.findByName(employee.getName());
		if (employe.isPresent()) {
			log.warn("hey " + employee.getName() + " your data is exits allready from service layer");
			throw new ResourceAllreadyExists("hey " + employee.getName() + " your data is exits allready");

		} else {
			repo.save(employee);
			log.info("processing the new admin data from service layer");
			return employee;
		}
	}

	@Override
	public Employee getEmployee(int id) {
		Optional<Employee> employee = repo.findById(id);
		if (employee.isPresent()) {
			log.info("hey admin " + employee.get().getName() + " your data is avaiable");
			return employee.get();
		} else {
			log.warn("hey admin your data is not found from service layer");
			throw new ResourseNotFound("hey admin your data is not found");
		}
	}

	@Override
	public void delEmployee(int id) {
		Optional<Employee> employee = repo.findById(id);
		if (employee.isPresent()) {
			log.info("details are found procssing to delete the data of " + employee.get().getName());
			repo.delete(employee.get());
		} else {
			log.warn("deatils of " + id + " is not found");
			throw new ResourseNotFound(
					"hey user your details are not found by this " + id + " please try with proper Id");
		}
	}

	@Override
	public Employee updEmployee(Employee employee) {
		Employee emp = repo.findById(employee.getId()).get();
		if (emp == null) {
			log.warn("deatils of " + employee.getName() + " is not found");
			throw new ResourseNotFound(
					"hey user your details are not found by this " + employee.getId() + " please try with proper Id");
		} else {
			log.info("details are found procssing to update the data of " + emp.getId());
			emp.setId(employee.getId());

			repo.save(emp);
			return emp;
		}
	}

	@Override
	public List<Employee> getAllEmp() {
		List<Employee> emp = repo.findAll();
		if (emp == null) {
			log.warn("deatils of all the admins are not found");
			throw new ResourseNotFound("hey user your details are not found");
		} else {
			log.info("hey admin we found all the details of admins they are");
			return emp;
		}
	}

}
