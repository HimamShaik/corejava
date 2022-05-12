package com.him.Hotel_Reservation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.him.Hotel_Reservation.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

	public Optional<Admin> findById(long id);

	public Optional<Admin> findByUsername(String username);

//	public List<Admin> findByUsername(String username);

}
