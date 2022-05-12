package com.him.Hotel_Reservation.model;

public class ErrorClass {

	private int status_Code;
	private String Message;

	public int getStatus_Code() {
		return status_Code;
	}

	public void setStatus_Code(int status_Code) {
		this.status_Code = status_Code;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

}
