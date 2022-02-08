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

import com.hms.application.entity.Doctor;
import com.hms.application.entity.Staff;
import com.hms.application.service.DoctorStaffServiceImpl;
import com.hms.application.service.StaffServiceImpl;

@RestController
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	StaffServiceImpl staffServiceImpl;
	
	Staff staff;

	@PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Staff> insertStaff(@Valid @RequestBody Staff staff) {
		staff = staffServiceImpl.insertStaff(staff);
		return new ResponseEntity<Staff>(staff, HttpStatus.OK);
	}

	@GetMapping(value = "/get/{staffId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Staff> getStaff(@PathVariable(name = "staffId") int staffId) {
		staff = staffServiceImpl.getStaff(staffId);
		return new ResponseEntity<Staff>(staff, HttpStatus.OK);
	}

	@PutMapping(value = "/update/{staffId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Staff> updateStaff(@Valid @RequestBody Staff staff,
			@PathVariable(name = "staffId") int staffId) {
		staff = staffServiceImpl.updateStaff(staff, staffId);
		return new ResponseEntity<Staff>(staff, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{staffId}")
	public ResponseEntity<HttpStatus> deleteStaff(@PathVariable("staffId") int staffId){
		staffServiceImpl.deleteStaff(staffId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
