package com.fenton.rest_api.repository;

import com.fenton.rest_api.Model.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
    boolean existsByEmail(String email);
    Optional<StudentProfile> findByEmail(String email);
}
