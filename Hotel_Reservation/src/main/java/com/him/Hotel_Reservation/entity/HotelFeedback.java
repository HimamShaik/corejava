//package com.him.Hotel_Reservation.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//
//@Entity
//public class HotelFeedback {
//	@Id
//	private int feedBackId;
//	private String message;
//	private int custmerId;
//	private int rating;
//
//	@OneToOne
//	@JoinColumn(name = "booking_Id")
//	private RoomBooking roombook;
//
//	public int getFeedBackId() {
//		return feedBackId;
//	}
//
//	public void setFeedBackId(int feedBackId) {
//		this.feedBackId = feedBackId;
//	}
//
//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}
//
//	public int getCustmerId() {
//		return custmerId;
//	}
//
//	public void setCustmerId(int custmerId) {
//		this.custmerId = custmerId;
//	}
//
//	public int getRating() {
//		return rating;
//	}
//
//	public void setRating(int rating) {
//		this.rating = rating;
//	}
//
//	public RoomBooking getRoombook() {
//		return roombook;
//	}
//
//	public void setRoombook(RoomBooking roombook) {
//		this.roombook = roombook;
//	}
//
//	
//}
