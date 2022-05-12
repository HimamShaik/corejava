package com.him.Hotel_Reservation.service;

import java.util.List;

import com.him.Hotel_Reservation.entity.Admin;
import com.him.Hotel_Reservation.entity.Employee;

public interface EmployeeService {

public Employee addingEmployee(Employee emp);
	
	public Employee getEmployee(int id);
	
	public void delEmployee(int id);
	
	public Employee updEmployee(Employee emp);
	
	public List<Employee> getAllEmp();
	
}
