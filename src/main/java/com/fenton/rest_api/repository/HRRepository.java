package com.fenton.rest_api.repository;

import com.fenton.rest_api.Model.Admin;
import com.fenton.rest_api.Model.HR;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HRRepository extends JpaRepository<HR, Long> {
}
