package com.fenton.rest_api.servicelayer;

import com.fenton.rest_api.Model.StudentProfile;
import com.fenton.rest_api.ResourceNotFoundException;
import com.fenton.rest_api.repository.StudentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentProfileServiceImpl implements StudentService{

    private final StudentProfileRepository studentProfileRepository;

    @Autowired
    public StudentProfileServiceImpl(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    @Override
    public StudentProfile saveStudentProfile(StudentProfile studentProfile){
        return studentProfileRepository.save(studentProfile);
    }

    @Override
    public StudentProfile updateStudentProfile(Long id,StudentProfile std){
        StudentProfile existingStudent=studentProfileRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student","ID",id));
        existingStudent.setFirstName(std.getFirstName());
        existingStudent.setLastName(std.getLastName());
        existingStudent.setEmail(std.getEmail());
        existingStudent.setDob(std.getDob());
        studentProfileRepository.save(existingStudent);
        return existingStudent;
    }
}
