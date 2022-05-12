package com.him.Hotel_Reservation.service;

import java.util.List;

import com.him.Hotel_Reservation.entity.HotelRoom;

public interface HotelRoomService {

	public HotelRoom addRoom(HotelRoom room);

	public List<HotelRoom> getAllRooms();

	public HotelRoom updateRoom1(HotelRoom room);
}
