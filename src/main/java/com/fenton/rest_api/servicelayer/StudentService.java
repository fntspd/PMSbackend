package com.fenton.rest_api.servicelayer;

import com.fenton.rest_api.Model.Job;
import com.fenton.rest_api.Model.StudentProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StudentService {

    StudentProfile saveStudentProfile(StudentProfile studentProfile);

    List<StudentProfile> getAllStudentProfile();

    StudentProfile getStudentProfileById(Long stdid);

    StudentProfile updateStudentProfile(Long id,StudentProfile std);
    Long deleteById(Long id);
    List<Job> getJobsByStudentId(Long studentId);
    Job getJobById(Long jobId);
    List<Job> getAllOpenJobs();


}
