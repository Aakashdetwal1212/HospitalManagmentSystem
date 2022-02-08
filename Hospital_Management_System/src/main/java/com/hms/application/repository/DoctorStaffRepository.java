package com.hms.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.application.entity.Doctor;

@Repository
public interface DoctorStaffRepository extends JpaRepository<Doctor, Integer> {

}
