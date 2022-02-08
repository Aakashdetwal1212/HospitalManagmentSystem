package com.hms.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.application.entity.Admin;
import com.hms.application.entity.Nurse;
import com.hms.application.exception.ResourceNotFoundException;
import com.hms.application.repository.AdminStaffRepository;
import com.hms.application.repository.NurseStaffRepository;

@Service
public class AdminStaffServiceImpl implements HospitalStaffService {

	@Autowired
	AdminStaffRepository adminStaffRepository;

	@Transactional(readOnly = false)
	public Admin insertAdminStaff(Admin admin) {
		return adminStaffRepository.save(admin);
	}

	@Transactional(readOnly = true)
	public Admin getAdmin(int adminId) {
		return adminStaffRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Resource " + adminId + " not found"));
	}

	@Transactional(readOnly = false)
	public void deleteAdmin(int adminId) {
		adminStaffRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Resource " + adminId + " not found"));
		adminStaffRepository.deleteById(adminId);
	}

	@Transactional(readOnly = false)
	public Admin updateAdmin(Admin adminUpdated, int adminId) {
		Admin adminOld = adminStaffRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Resource " + adminId + " not found"));

		adminOld.setName(adminUpdated.getName());
		adminOld.setCity(adminUpdated.getCity());
		adminOld.setAge(adminUpdated.getAge());
		adminOld.setMobile(adminUpdated.getMobile());
		adminOld.setGender(adminUpdated.getGender());
		adminOld.setUserName(adminUpdated.getUserName());
		adminOld.setPassword(adminUpdated.getPassword());
		return adminStaffRepository.save(adminOld);
	}
}
