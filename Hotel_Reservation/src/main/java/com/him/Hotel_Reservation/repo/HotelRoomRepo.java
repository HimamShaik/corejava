package com.him.Hotel_Reservation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Optional;
import com.him.Hotel_Reservation.entity.HotelRoom;

@Repository
public interface HotelRoomRepo extends JpaRepository<HotelRoom, Integer> {

	public Optional<HotelRoom> findByroomNo(int roomNo);

//	 public Optional<HotelRoom> getById(int roomNo);

	// public List<HotelRoom>
}
