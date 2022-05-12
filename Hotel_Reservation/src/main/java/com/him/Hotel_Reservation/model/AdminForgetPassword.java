package com.him.Hotel_Reservation.model;

public class AdminForgetPassword {

	private String admin_Name;
	private long admin_PhoneNO;
	private String newPassword;

	public String getAdmin_Name() {
		return admin_Name;
	}

	public void setAdmin_Name(String admin_Name) {
		this.admin_Name = admin_Name;
	}

	public long getAdmin_PhoneNO() {
		return admin_PhoneNO;
	}

	public void setAdmin_PhoneNO(long admin_PhoneNO) {
		this.admin_PhoneNO = admin_PhoneNO;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public AdminForgetPassword(String admin_Name, long admin_PhoneNO, String newPassword) {
		super();
		this.admin_Name = admin_Name;
		this.admin_PhoneNO = admin_PhoneNO;
		this.newPassword = newPassword;
	}

}
