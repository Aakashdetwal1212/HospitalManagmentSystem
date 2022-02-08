package com.hms.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.application.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {

}
