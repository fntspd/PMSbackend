package com.fenton.rest_api.repository;

import com.fenton.rest_api.Model.AddStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddStudentRepository extends JpaRepository<AddStudent, Long> {
}
