package com.him.Hotel_Reservation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.him.Hotel_Reservation.entity.HotelRoom;
import com.him.Hotel_Reservation.entity.RoomBooking;

@Repository
public interface RoomBookingRepo extends JpaRepository<RoomBooking, Integer> {

	// public Optional<RoomBooking> findByroomno(RoomBooking hootelRoom);
	
	//public Optional<HotelRoom> findByfindByhootel_room_room_no(int roomNo);

	public Optional<HotelRoom> getById(int roomno);
}
