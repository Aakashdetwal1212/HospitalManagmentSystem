package com.hms.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.application.entity.Nurse;

@Repository
public interface NurseStaffRepository extends JpaRepository<Nurse, Integer> {

}
