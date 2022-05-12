package com.him.Hotel_Reservation.entity;

public class Response {

	private int StatusCode;
	private String message;

	public int getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(int statusCode) {
		StatusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Response(int statusCode, String message) {
		super();
		StatusCode = statusCode;
		this.message = message;
	}

}
