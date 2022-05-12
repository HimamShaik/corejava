package com.him.Hotel_Reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.him.Hotel_Reservation.entity.HotelRoom;
import com.him.Hotel_Reservation.exception.ResourceAllreadyExists;
import com.him.Hotel_Reservation.exception.ResourseNotFound;
import com.him.Hotel_Reservation.repo.HotelRoomRepo;

@Service
public class HotelRoomServiceImpl implements HotelRoomService {

	@Autowired
	private HotelRoomRepo repo;

	@Override
	public HotelRoom addRoom(HotelRoom room) {
		Optional<HotelRoom> findroom = repo.findByroomNo(room.getRoomNo());
		if (findroom.isPresent()) {
			throw new ResourceAllreadyExists(
					"hey admin details are allready exists on this room no" + room.getRoomNo());
		} else {
			HotelRoom hotel = repo.save(room);
			return hotel;
		}
	}

	@Override
	public List<HotelRoom> getAllRooms() {
		List<HotelRoom> getallrooms = repo.findAll();
		return getallrooms;
	}

	@Override
	public HotelRoom updateRoom1(HotelRoom room) {
		Optional<HotelRoom> roomfetch=repo.findByroomNo(room.getRoomNo());
		if(roomfetch!=null) {
			roomfetch.get().setRoomNo(room.getRoomNo());
			roomfetch.get().setRoomCost(room.getRoomCost());
			roomfetch.get().setRoomFlore(room.getRoomFlore());
			roomfetch.get().setRoomSize(room.getRoomSize());
			roomfetch.get().setRoomType(room.getRoomType());
			roomfetch.get().setStatus(room.getStatus());
			HotelRoom room1=repo.save(roomfetch.get());
			return room1;
		}else {
			throw new ResourseNotFound("hey admin data is not found by using this room no "+room.getRoomNo());
		}
	}
}
