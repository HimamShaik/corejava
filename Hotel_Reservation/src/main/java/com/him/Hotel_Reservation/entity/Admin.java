package com.him.Hotel_Reservation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "pls provide admin_id it should not be empty")
	@JsonIgnore
	private long adminId;
	@NotEmpty(message = "pls provide name_it should not be empty")
	private String adminName;
	@NotEmpty(message = "pls provide username it should not be empty")
	private String username;
	@NotNull(message = "pls provide user_age it should not be empty")
	private int adminAge;
	@NotNull(message = "pls provide user_phone-no it should not be empty")
	private long adminPhoneNO;
	@NotEmpty(message = "pls provide user_password it should not be empty")
	private String password;

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAdminAge() {
		return adminAge;
	}

	public void setAdminAge(int adminAge) {
		this.adminAge = adminAge;
	}

	public long getAdminPhoneNO() {
		return adminPhoneNO;
	}

	public void setAdminPhoneNO(long adminPhoneNO) {
		this.adminPhoneNO = adminPhoneNO;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
