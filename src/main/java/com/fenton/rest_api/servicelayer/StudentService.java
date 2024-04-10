package com.fenton.rest_api.servicelayer;

import com.fenton.rest_api.Model.StudentProfile;

import java.util.List;

public interface StudentService {

    StudentProfile saveStudentProfile(StudentProfile studentProfile);

    StudentProfile updateStudentProfile(Long id,StudentProfile std);


}
