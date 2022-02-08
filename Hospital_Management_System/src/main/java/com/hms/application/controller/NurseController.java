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

import com.hms.application.entity.Nurse;
import com.hms.application.entity.Staff;
import com.hms.application.service.NurseStaffServiceImpl;
import com.hms.application.service.StaffServiceImpl;

@RestController
@RequestMapping("/nurse")
public class NurseController {

	@Autowired
	NurseStaffServiceImpl nurseStaffServiceImpl;
	
	Nurse nurse;

	@PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Nurse> insertNurse(@Valid @RequestBody Nurse nurse) {
		nurse = nurseStaffServiceImpl.insertNurseStaff(nurse);
		return new ResponseEntity<Nurse>(nurse, HttpStatus.OK);
	}

	@GetMapping(value = "/get/{nurseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Nurse> getNurse(@PathVariable(name = "nurseId") int nurseId) {
		nurse = nurseStaffServiceImpl.getNurse(nurseId);
		return new ResponseEntity<Nurse>(nurse, HttpStatus.OK);
	}

	@PutMapping(value = "/update/{nurseId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Nurse> updateNurse(@Valid @RequestBody Nurse nurse,
			@PathVariable(name = "nurseId") int nurseId) {
		nurse = nurseStaffServiceImpl.updateNurse(nurse, nurseId);
		return new ResponseEntity<Nurse>(nurse, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{nurseId}")
	public ResponseEntity<HttpStatus> deleteNurse(@PathVariable("nurseId") int nurseId){
		nurseStaffServiceImpl.deleteNurse(nurseId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
