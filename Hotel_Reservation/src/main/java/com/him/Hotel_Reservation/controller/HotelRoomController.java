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

import com.him.Hotel_Reservation.entity.HotelRoom;
import com.him.Hotel_Reservation.service.HotelRoomService;

@RestController
@RequestMapping("/api")
public class HotelRoomController {

	@Autowired
	private HotelRoomService service;

	@PostMapping("/addRoom")
	public ResponseEntity<Object> addRoom(@RequestBody HotelRoom room) {
		HotelRoom hotel = service.addRoom(room);
		return new ResponseEntity<Object>(hotel, HttpStatus.CREATED);

	}

	@PutMapping("/getAllRooms")
	public ResponseEntity<Object> getAllRoom() {
		List<HotelRoom> allrooms = service.getAllRooms();
		return new ResponseEntity<Object>(allrooms, HttpStatus.OK);
	}

	@PutMapping("/updateRoom")
	public ResponseEntity<Object> updateRoom(@RequestBody HotelRoom room) {
		HotelRoom updated = service.updateRoom1(room);
		// return new ResponseEntity<Object>(updated, HttpStatus.ACCEPTED);
		return new ResponseEntity<Object>(updated, HttpStatus.OK);
	}

}
