package com.him.Hotel_Reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.him.Hotel_Reservation.entity.RoomBooking;
import com.him.Hotel_Reservation.model.RoomBookingModel;
import com.him.Hotel_Reservation.service.RoomBookingService;

@RestController
@RequestMapping("/api")
public class RoomBookingController {
	@Autowired
	private RoomBookingService service;
//booking hotel via roombooking entity

//	@PostMapping("/doBooking")
//	public ResponseEntity<Object> doBooking(@RequestBody RoomBooking book){
//		RoomBooking room=service.doBook(book);
//		return new ResponseEntity<Object>(room, HttpStatus.ACCEPTED);
//	}
//booking done by via roombookingmodel class
	@PutMapping("/dobook")
	public ResponseEntity<Object> dobook(@RequestBody RoomBooking room) {
		RoomBooking bookingdone;
		synchronized (room) {
			bookingdone = service.doBook(room);

		}
		return new ResponseEntity<Object>(bookingdone, HttpStatus.OK);
	}

	@GetMapping("/getAllBookings")
	public ResponseEntity<Object> getAllRooms() {
		List<RoomBooking> roomList = service.getAlRoom();
		return new ResponseEntity<Object>(roomList, HttpStatus.ACCEPTED);
	}

}
