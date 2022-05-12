package com.him.Hotel_Reservation.controller;

import java.util.List;

import javax.persistence.PersistenceUnits;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.him.Hotel_Reservation.entity.Admin;
import com.him.Hotel_Reservation.entity.Response;
import com.him.Hotel_Reservation.exception.InvalidCredentialException;
import com.him.Hotel_Reservation.model.AdminForgetPassword;
import com.him.Hotel_Reservation.service.AdminService;

@RestController
@RequestMapping("/api")
public class AdminController {

	@Autowired
	private AdminService service;
	Response response = new Response();

	Logger log = Logger.getLogger(AdminController.class.getName());

	@PostMapping("/addAdmin")
	public ResponseEntity<Object> addAdmin(@RequestBody Admin admin) {

		service.addingAdmin(admin);
		log.info("admin data is adding via calling service method");
		response.setStatusCode(601);
		response.setMessage("hey " + admin.getUsername() + " your data is added successfully");
		return new ResponseEntity<Object>(response, HttpStatus.CREATED);

	}

	@GetMapping("/getAdmin/{id}")
	public ResponseEntity<Object> getAdmin(@PathVariable int id,
			@SessionAttribute(name = "myses", required = false) Admin admin1) {
		Admin admin2 = admin1;
		if (admin1 != null) {
			log.info("processing the data passing through the service layer");
			Admin admin = service.getAddmin(id);
			if (admin.getAdminId() == admin2.getAdminId()) {

//		response.setStatusCode(602);
//		response.setMessage("hey " + admin.getAdmin_Name() + " your details age available");
				return new ResponseEntity<Object>(admin, HttpStatus.FOUND);
			} else {
				throw new InvalidCredentialException("hey admin your data only can you fetch");
			}
		} else {
			log.warn("hey admin plese try to login first");
			throw new InvalidCredentialException(
					"hey user please first login into your account then you can get the details");
		}
	}

	@DeleteMapping("/deleteAdmin/{id}")
	public ResponseEntity<Object> deleteAdmin(@PathVariable int id,
			@SessionAttribute(name = "myses", required = false) Admin admin1) {

		if (admin1 != null) {
			log.info("processing the data passing through the service layer");
			service.delAdmin(id);
			response.setStatusCode(602);
			response.setMessage("hey admin " + id + " this data is deleted");
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		} else {
			log.warn("hey admin plese try to login first");
			throw new InvalidCredentialException(
					"hey user please first login into your account then you can get the details of yours");
		}
	}

	@PutMapping("/updateAdmin")
	public ResponseEntity<Object> updateAdmin(@RequestBody Admin admin,
			@SessionAttribute(name = "myses", required = false) Admin admin1) {
		if (admin1 != null) {
			log.info("processing the data passing through the service layer");
			Admin admin2 = service.updAdmin(admin);
			return new ResponseEntity<Object>(admin2, HttpStatus.OK);
		} else {
			log.warn("hey admin plese try to login first");
			throw new InvalidCredentialException(
					"hey user please first login into your account then you can update your account details");
		}
	}

	@GetMapping("/getAllAdmin")
	public ResponseEntity getAllAdmin(@SessionAttribute(name = "myses", required = false) Admin admin1) {
		if (admin1 != null) {
			List<Admin> admin = service.getAllAd();
			return new ResponseEntity(admin, HttpStatus.OK);
		} else {
			log.warn("hey admin plese try to login first");
			throw new InvalidCredentialException(
					"hey user please first login into your account then you can get all the details of admin's");
		}
	}

	@PostMapping("/adminLogin/{username}/{password}")
	public ResponseEntity<Object> checkAdminCredentials(@PathVariable String username, @PathVariable String password,
			HttpServletRequest re) {
		log.debug("calling service layer");
		HttpSession session = re.getSession();
		Admin admin = service.checkCredential(username, password);
		log.info("return via service to controller");
		if (admin != null) {
			session.setAttribute("myses", admin);
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setMessage("hey user your login was succesfully done ");
			return new ResponseEntity<Object>(response, HttpStatus.FOUND);
		} else {
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setMessage("hey user your login was not successfull");
			return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/forgetAdminPass")
	public ResponseEntity<Object> forgetPassword(@RequestBody AdminForgetPassword forget,
			@SessionAttribute(name = "myses", required = false) Admin admin1) {
		if (admin1 != null) {
			service.adminFoget(forget);
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setMessage("hey user password is updated");
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		} else {
			log.warn("hey admin plese try to login first");
			throw new InvalidCredentialException(
					"hey user please first login into your account then you can reset your account password");
		}
	}

	@PutMapping("/adminLogout")
	public ResponseEntity<Object> adminLogout(HttpSession session,
			@SessionAttribute(name = "myses", required = false) Admin admin1) {
		session.getAttribute("admin1");
		session.invalidate();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("hey user you have successfully logedout");
		return new ResponseEntity<Object>(response, HttpStatus.OK);

	}

}
