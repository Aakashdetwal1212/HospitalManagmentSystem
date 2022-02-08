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
import com.hms.application.service.DoctorStaffServiceImpl;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {

	@Autowired
	DoctorStaffServiceImpl doctorStaffServiceImpl;
	
	Doctor doctor;

	@PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Doctor> insertDoctorStaff(@Valid @RequestBody Doctor doctor) {
		doctor = doctorStaffServiceImpl.insertDoctorStaff(doctor);
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
	}

	@GetMapping(value = "/get/{doctorId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Doctor> getDoctor(@PathVariable(name = "doctorId") int doctorId) {
		doctor = doctorStaffServiceImpl.getDoctorStaff(doctorId);
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
	}

	@PutMapping(value = "/update/{doctorId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Doctor> updateDoctor(@Valid @RequestBody Doctor doctor,
			@PathVariable(name = "doctorId") int doctorId) {
		doctor = doctorStaffServiceImpl.updateDoctor(doctor, doctorId);
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{doctorId}")
	public ResponseEntity<HttpStatus> deleteDoctor(@PathVariable("doctorId") int doctorId){
		doctorStaffServiceImpl.deleteDoctor(doctorId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
