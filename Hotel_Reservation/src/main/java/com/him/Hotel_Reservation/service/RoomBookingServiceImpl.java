package com.him.Hotel_Reservation.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.him.Hotel_Reservation.entity.Customer;
import com.him.Hotel_Reservation.entity.HotelRoom;
import com.him.Hotel_Reservation.entity.RoomBooking;
import com.him.Hotel_Reservation.exception.InvalidCredentialException;
import com.him.Hotel_Reservation.exception.ResourceAllreadyExists;
import com.him.Hotel_Reservation.exception.ResourseNotFound;
import com.him.Hotel_Reservation.model.RoomBookingModel;
import com.him.Hotel_Reservation.repo.CustomerRepo;
import com.him.Hotel_Reservation.repo.HotelRoomRepo;
import com.him.Hotel_Reservation.repo.RoomBookingRepo;

@Service
public class RoomBookingServiceImpl implements RoomBookingService {

	@Autowired
	private RoomBookingRepo bookRepo;
	@Autowired
	private CustomerRepo custRepo;
	@Autowired
	private HotelRoomRepo roomRepo;

	@Override
	public RoomBooking doBook(RoomBooking book) {
		Customer cust = custRepo.getById(book.getCustomerId());

		HotelRoom rom = roomRepo.getById(book.getRoomNo());
		rom.setStatus("occupied");
		book.setRoomstatus("occupied");
		book.setCustomer(cust);
		book.setHootelRoom(rom);
		
		
		/*
		 * RoomBooking booking = new RoomBooking(); Customer cust1 = new Customer();
		 * HotelRoom room = new HotelRoom();
		 * 
		 * final String roomstatus = "occupied";
		 * 
		 * booking.setBookingId(book.getBookingId());
		 * booking.setHowmanyDays(book.getHowmanyDays());
		 * booking.setBookdate(book.getBookdate());
		 * booking.setBookeddate(book.getBookeddate());
		 * booking.setBookedtime(book.getBookedtime());
		 * booking.setRoomstatus(roomstatus); booking.setCustomer(cust);
		 * booking.setHootelRoom(rom); room.setStatus(roomstatus);
		 */
//		cust1.setHotelroom(rom.setRoomNo(book.getRoomNo()));
//		room.setCustomer(cust);
		
		return bookRepo.save(book);

		//roomRepo.save();
		//RoomBooking bookingdone = bookRepo.save(booking);
//		HotelRoom room1 = roomRepo.save(room);
//		Customer customoer = custRepo.save(cust1);

		//return bookingdone;

	}

	@Override
	public List<RoomBooking> getAlRoom() {
//		List<RoomBooking> cust= (List<RoomBooking>) bookRepo.findAll();
		List<RoomBooking> cust = bookRepo.findAll();
		if (cust.isEmpty()) {
			throw new ResourseNotFound("hey admin there is no data present in the list of booking");
		} else {

			return cust;
		}
	}

//	@Override
//	public RoomBooking doBook(RoomBooking book) {
//		RoomBooking booking = new RoomBooking();
//		Customer cust = new Customer();
//
//		cust.setCustId(book.getCustomer().getCustId());
//		cust.setCustPassword(book.getCustomer().getCustPassword());
//
//		if (cust.getCustId() != 0 && cust.getCustPassword() != null) {
//
//			if (custRepo.getById(cust.getCustId()).getCustPassword().equals(cust.getCustPassword())) {
//				Customer willBook = custRepo.getById(cust.getCustId());
//				booking.setCustomer(willBook);
//				HotelRoom rooms = new HotelRoom();
//				// int roomNumberBooked = book.getHootelRoom().getRoomNo();
//				rooms = repoRoom.getById(book.getHootelRoom().getRoomNo());
//				booking.setHootelRoom(rooms);
//				booking.setBookingDays(book.getBookingDays());
//
//			} else {
//				System.out.println("password and id is null");
//				throw new InvalidCredentialException("hey cutomer your data is incorrect");
//
//			}
//
//		} else {
//			System.out.println("password and id is null");
//			throw new InvalidCredentialException("hey cutomer your password is null");
//
//		}
//
//		RoomBooking room = repo.save(booking);
//
//		return room;
//	}
}
