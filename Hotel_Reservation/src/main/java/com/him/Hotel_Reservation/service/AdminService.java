package com.him.Hotel_Reservation.service;

import java.util.List;

import com.him.Hotel_Reservation.entity.Admin;
import com.him.Hotel_Reservation.model.AdminForgetPassword;

public interface AdminService {
	
	public Admin addingAdmin(Admin admin);
	
	public Admin getAddmin(int id);
	
	public void delAdmin(int id);
	
	public Admin updAdmin(Admin admin);
	
	public List<Admin> getAllAd();
	
	public Admin checkCredential(String username,String password);
	
	public void adminFoget(AdminForgetPassword adminfoget);

}
