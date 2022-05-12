package com.him.Hotel_Reservation.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.him.Hotel_Reservation.controller.AdminController;
import com.him.Hotel_Reservation.entity.Admin;
import com.him.Hotel_Reservation.exception.InvalidCredentialException;
import com.him.Hotel_Reservation.exception.ResourceAllreadyExists;
import com.him.Hotel_Reservation.exception.ResourseNotFound;
import com.him.Hotel_Reservation.model.AdminForgetPassword;
import com.him.Hotel_Reservation.repo.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepo repo;

	Logger log = Logger.getLogger(AdminServiceImpl.class.getName());

	public Admin addingAdmin(Admin admin) {
		Optional<Admin> findAdmin = repo.findByUsername(admin.getUsername());
		if (findAdmin.isPresent()) {
			log.warn("hey " + admin.getAdminName() + " your data is exits allready from service layer");
			throw new ResourceAllreadyExists(
					"hey " + admin.getAdminName() + " this user name is allready exists pls try with another one");

		} else {
			repo.save(admin);
			log.info("processing the new admin data from service layer");
			return admin;
		}
	}

	@Override
	public Admin getAddmin(int id) {
		Optional<Admin> admin = repo.findById(id);
		if (admin.isPresent()) {
			log.info("hey admin " + admin.get().getAdminName() + " your data is avaiable");
			return admin.get();
		} else {
			log.warn("hey admin your data is not found from service layer");
			throw new ResourseNotFound("hey admin your data is not found");
		}
	}

	@Override
	public void delAdmin(int id) {
		Optional<Admin> admin = repo.findById(id);
		if (admin.isPresent()) {
			log.info("details are found procssing to delete the data of " + admin.get().getAdminName());
			repo.delete(admin.get());
		} else {
			log.warn("deatils of " + id + " is not found");
			throw new ResourseNotFound(
					"hey user your details are not found by this " + id + " please try with proper Id");
		}
	}

	@Override
	public Admin updAdmin(Admin admin) {
		Admin admin1 = repo.findById(admin.getAdminId()).get();
		if (admin1 == null) {
			log.warn("deatils of " + admin.getAdminName() + " is not found");
			throw new ResourseNotFound(
					"hey user your details are not found by this " + admin.getAdminId() + " please try with proper Id");
		} else {
			log.info("details are found procssing to update the data of " + admin1.getAdminName());
			admin1.setAdminId(admin.getAdminId());
			admin1.setAdminName(admin.getAdminName());
			admin1.setAdminAge(admin.getAdminAge());
			admin1.setUsername(admin.getUsername());
			admin1.setAdminPhoneNO(admin.getAdminPhoneNO());
			admin1.setPassword(admin.getPassword());
			repo.save(admin1);
			return admin1;
		}
	}

	@Override
	public List<Admin> getAllAd() {
		List<Admin> admin = repo.findAll();
		if (admin == null) {
			log.warn("deatils of all the admins are not found");
			throw new ResourseNotFound("hey user your details are not found");
		} else {
			log.info("hey admin we found all the details of admins they are");
			return admin;
		}
	}

	@Override
	public Admin checkCredential(String username, String password) {
		Optional<Admin> admin = repo.findByUsername(username);

		if (admin.isPresent()) {
			log.info("checkng the password");
			if (password.equals(admin.get().getPassword())) {

				return admin.get();
			} else {
				throw new InvalidCredentialException("invalid password please enter the correct password");
			}
		} else {

			throw new InvalidCredentialException("No data found by this Username");
		}
	}

	@Override
	public void adminFoget(AdminForgetPassword adminfoget) {
		Optional<Admin> adminfind = repo.findByUsername(adminfoget.getAdmin_Name());
		if (adminfind.isPresent()) {
			log.info("processing the data check");
			if (adminfind.get().getAdminPhoneNO() == adminfoget.getAdmin_PhoneNO()) {
				log.info("username and phone no matched setting new password");
				adminfind.get().setPassword(adminfoget.getNewPassword());
				repo.save(adminfind.get());
			} else {
				throw new InvalidCredentialException("hey user please eter the proper phoneno");
			}
		} else {
			throw new ResourseNotFound("hey user your data is not found");
		}
	}

}
