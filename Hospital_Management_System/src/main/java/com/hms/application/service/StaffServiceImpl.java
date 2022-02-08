package com.hms.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.application.entity.Staff;
import com.hms.application.exception.ResourceNotFoundException;
import com.hms.application.repository.StaffRepository;

@Service
public class StaffServiceImpl implements HospitalStaffService {

	@Autowired
	StaffRepository staffRepository;

	@Transactional(readOnly = false)
	public Staff insertStaff(Staff staff) {
		return staffRepository.save(staff);
	}

	@Transactional(readOnly = true)
	public Staff getStaff(int staffId) {
		return staffRepository.findById(staffId)
				.orElseThrow(() -> new ResourceNotFoundException("Resource " + staffId + " not found"));
	}

	@Transactional(readOnly = false)
	public void deleteStaff(int staffId) {
		staffRepository.findById(staffId)
				.orElseThrow(() -> new ResourceNotFoundException("Resource " + staffId + " not found"));
		staffRepository.deleteById(staffId);
	}

	@Transactional(readOnly = false)
	public Staff updateStaff(Staff staffUpdated, int staffId) {
		Staff staffOld = staffRepository.findById(staffId)
				.orElseThrow(() -> new ResourceNotFoundException("Resource " + staffId + " not found"));

		staffOld.setName(staffUpdated.getName());
		staffOld.setCity(staffUpdated.getCity());
		staffOld.setAge(staffUpdated.getAge());
		staffOld.setMobile(staffUpdated.getMobile());
		staffOld.setGender(staffUpdated.getGender());
		staffOld.setExperience(staffUpdated.getExperience());
		staffOld.setSubDepartment(staffUpdated.getSubDepartment());
		System.out.println("staff::::::::::::" + staffOld);
		return staffRepository.save(staffOld);
	}
	
}
