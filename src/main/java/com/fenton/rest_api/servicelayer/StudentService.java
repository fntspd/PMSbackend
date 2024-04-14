package com.fenton.rest_api.servicelayer;

import com.fenton.rest_api.Model.StudentProfile;

import java.util.List;

public interface StudentService {

    StudentProfile saveStudentProfile(StudentProfile studentProfile);

    List<StudentProfile> getAllStudentProfile();

    StudentProfile getStudentProfileById(Long stdid);

    StudentProfile updateStudentProfile(Long id,StudentProfile std);
    Long deleteById(Long id);


}
