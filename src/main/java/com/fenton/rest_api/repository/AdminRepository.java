package com.fenton.rest_api.repository;

import com.fenton.rest_api.Model.Admin;
import com.fenton.rest_api.Model.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
