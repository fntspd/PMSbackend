package com.fenton.rest_api.repository;

import com.fenton.rest_api.Model.Admin;
import com.fenton.rest_api.Model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
