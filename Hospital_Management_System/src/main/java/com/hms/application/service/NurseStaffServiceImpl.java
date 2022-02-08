package com.hms.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.application.entity.Nurse;
import com.hms.application.entity.Staff;
import com.hms.application.exception.ResourceNotFoundException;
import com.hms.application.repository.NurseStaffRepository;
import com.hms.application.repository.StaffRepository;

@Service
public class NurseStaffServiceImpl implements HospitalStaffService {

	@Autowired
	NurseStaffRepository nurseStaffRepository;

	@Transactional(readOnly = false)
	public Nurse insertNurseStaff(Nurse nurse) {
		return nurseStaffRepository.save(nurse);
	}

	@Transactional(readOnly = true)
	public Nurse getNurse(int nurseId) {
		return nurseStaffRepository.findById(nurseId)
				.orElseThrow(() -> new ResourceNotFoundException("Resource " + nurseId + " not found"));
	}

	@Transactional(readOnly = false)
	public void deleteNurse(int nurseId) {
		nurseStaffRepository.findById(nurseId)
				.orElseThrow(() -> new ResourceNotFoundException("Resource " + nurseId + " not found"));
		nurseStaffRepository.deleteById(nurseId);
	}

	@Transactional(readOnly = false)
	public Nurse updateNurse(Nurse nurseUpdated, int nurseId) {
		Nurse nurseOld = nurseStaffRepository.findById(nurseId)
				.orElseThrow(() -> new ResourceNotFoundException("Resource " + nurseId + " not found"));

		nurseOld.setName(nurseUpdated.getName());
		nurseOld.setCity(nurseUpdated.getCity());
		nurseOld.setAge(nurseUpdated.getAge());
		nurseOld.setMobile(nurseUpdated.getMobile());
		nurseOld.setGender(nurseUpdated.getGender());
		nurseOld.setExperience(nurseUpdated.getExperience());
		nurseOld.setQualification(nurseUpdated.getQualification());
		return nurseStaffRepository.save(nurseOld);
	}
}
