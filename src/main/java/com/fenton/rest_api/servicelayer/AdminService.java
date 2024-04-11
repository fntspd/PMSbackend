package com.fenton.rest_api.servicelayer;

import com.fenton.rest_api.Model.*;

import java.util.List;

public interface AdminService {
    Admin admin(Admin admin);
    List<StudentProfile> getAllStudent();

    StudentProfile addStudent(StudentProfile studentProfile);
    AddStudent addstudentadmin(AddStudent addStudent);
    AddStudent updateStudentadmin(Long studentId, AddStudent addStudent);

    //Object addHr(HR hr);
    Company addCompany(Company company);
    Job postJob(Long companyId,Job job);
    StudentProfile updateStudent(Long stdId, StudentProfile studentProfile);
    Job updateJob(Long jobId,Job job);
}
