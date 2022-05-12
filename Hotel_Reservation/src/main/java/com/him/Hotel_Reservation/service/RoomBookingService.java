package com.him.Hotel_Reservation.service;

import java.util.List;

import com.him.Hotel_Reservation.entity.RoomBooking;
import com.him.Hotel_Reservation.model.RoomBookingModel;

public interface RoomBookingService {
	
	public RoomBooking doBook(RoomBooking book);
	
	public List<RoomBooking> getAlRoom();

}
