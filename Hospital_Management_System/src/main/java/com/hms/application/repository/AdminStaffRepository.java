package com.hms.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.application.entity.Admin;

@Repository
public interface AdminStaffRepository extends JpaRepository<Admin, Integer> {

}
