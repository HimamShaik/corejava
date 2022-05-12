package com.him.Hotel_Reservation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RoomBookingModel {

	@Id
	@JsonIgnore
	private int bookingId;
	private int howmanyDays;
	private Date bookdate = new Date();
	private String bookedtime;
	private String bookeddate;
	private int customerId;
	private int roomNo;

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

}
