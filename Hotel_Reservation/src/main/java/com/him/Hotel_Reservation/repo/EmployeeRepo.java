package com.him.Hotel_Reservation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.him.Hotel_Reservation.entity.Admin;
import com.him.Hotel_Reservation.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	public Optional<Employee> findById(int id);

	public Optional<Employee> findByName(String name);
}
