package com.hms.application.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.application.entity.Doctor;
import com.hms.application.exception.ResourceNotFoundException;
import com.hms.application.repository.DoctorStaffRepository;

@Service
public class DoctorStaffServiceImpl implements HospitalStaffService {

	@Autowired
	DoctorStaffRepository doctorStaffRepository;

	@Transactional(readOnly = false)
	public Doctor insertDoctorStaff(Doctor doctor) {
		return doctorStaffRepository.save(doctor);
	}

	@Transactional(readOnly = true)
	public Doctor getDoctorStaff(int doctorId) {
		return doctorStaffRepository.findById(doctorId)
				.orElseThrow(() -> new ResourceNotFoundException("Resource " + doctorId + " not found"));
	}

	@Transactional(readOnly = false)
	public void deleteDoctor(int doctorId) {
		doctorStaffRepository.findById(doctorId)
				.orElseThrow(() -> new ResourceNotFoundException("Resource " + doctorId + " not found"));
		doctorStaffRepository.deleteById(doctorId);
	}

	@Transactional(readOnly = false)
	public Doctor updateDoctor(Doctor doctorUpdated, int doctorId) {
		Doctor doctorOld = doctorStaffRepository.findById(doctorId)
				.orElseThrow(() -> new ResourceNotFoundException("Resource " + doctorId + " not found"));

		doctorOld.setName(doctorUpdated.getName());
		doctorOld.setCity(doctorUpdated.getCity());
		doctorOld.setAge(doctorUpdated.getAge());
		doctorOld.setMobile(doctorUpdated.getMobile());
		doctorOld.setGender(doctorUpdated.getGender());
		doctorOld.setSpecialization(doctorUpdated.getSpecialization());
		doctorOld.setExperience(doctorUpdated.getExperience());
		System.out.println("doctor::::::::::::" + doctorOld);
		return doctorStaffRepository.save(doctorOld);
	}

}
