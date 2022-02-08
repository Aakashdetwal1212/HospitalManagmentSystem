package com.hms.application.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.application.entity.Admin;
import com.hms.application.entity.Staff;
import com.hms.application.service.AdminStaffServiceImpl;
import com.hms.application.service.StaffServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminStaffServiceImpl adminStaffServiceImpl;
	
	Admin admin;

	@PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Admin> insertAdmin(@Valid @RequestBody Admin admin) {
		admin = adminStaffServiceImpl.insertAdminStaff(admin);
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}

	@GetMapping(value = "/get/{adminId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Admin> getAdmin(@PathVariable(name = "adminId") int adminId) {
		admin = adminStaffServiceImpl.getAdmin(adminId);
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}

	@PutMapping(value = "/update/{adminId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Admin> updateAdmin(@Valid @RequestBody Admin admin,
			@PathVariable(name = "adminId") int adminId) {
		admin = adminStaffServiceImpl.updateAdmin(admin, adminId);
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{adminId}")
	public ResponseEntity<HttpStatus> deleteAdmin(@PathVariable("adminId") int adminId){
		adminStaffServiceImpl.deleteAdmin(adminId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
