package com.him.Hotel_Reservation.entity;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class RoomBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int bookingId;
	private int howmanyDays;
	private Date bookdate = new Date();
	private String bookedtime;
	private String bookeddate;
	@JsonIgnore
	private String roomstatus;
	private int customerId;
	private int roomNo;

	
	

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	@ManyToOne @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@JsonIgnore
	private Customer customer;
	@ManyToOne
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JsonIgnore
	private HotelRoom hootelRoom;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getHowmanyDays() {
		return howmanyDays;
	}

	public void setHowmanyDays(int howmanyDays) {
		this.howmanyDays = howmanyDays;
	}

	public Date getBookdate() {
		return bookdate;
	}

	public void setBookdate(Date bookdate) {
		this.bookdate = bookdate;
	}

	public String getBookedtime() {
		return bookedtime;
	}

	public void setBookedtime(String bookedtime) {
		this.bookedtime = bookedtime;
	}

	public String getBookeddate() {
		return bookeddate;
	}

	public void setBookeddate(String bookeddate) {
		this.bookeddate = bookeddate;
	}

	public String getRoomstatus() {
		return roomstatus;
	}

	public void setRoomstatus(String roomstatus) {
		this.roomstatus = roomstatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public HotelRoom getHootelRoom() {
		return hootelRoom;
	}

	public void setHootelRoom(HotelRoom hootelRoom) {
		this.hootelRoom = hootelRoom;
	}
	
	
	

}
