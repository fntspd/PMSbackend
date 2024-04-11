package com.fenton.rest_api.servicelayer;

import com.fenton.rest_api.Model.*;

import java.util.List;

public interface AdminService {
    Admin admin(Admin admin);
    List<StudentProfile> getAllStudent();
    List<Company> getAllCompany();
    List<Job> getAllJobs();

    StudentProfile addStudent(StudentProfile studentProfile);

    //Object addHr(HR hr);
    Company addCompany(Company company);
    Job postJob(Long companyId,Job job);
    StudentProfile updateStudent(Long stdId, StudentProfile studentProfile);
    Job updateJob(Long jobId,Job job);
    Long deleteJobById(Long jobId);
}
