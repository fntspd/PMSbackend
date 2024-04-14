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
    public List<StudentProfile> getAllStudentProfile() {
        return studentProfileRepository.findAll();
    }

    @Override
    public StudentProfile getStudentProfileById(Long stdid) {
        Optional<StudentProfile> employee = studentProfileRepository.findById(stdid);
        if (employee.isPresent()){
            return employee.get();
        }else{
            throw new ResourceNotFoundException("StudentProfile","ID",stdid);
        }
    }

    @Override
    public StudentProfile updateStudentProfile(Long id,StudentProfile std){
        StudentProfile existingStudent=studentProfileRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","ID",id));
        existingStudent.setFirstName(std.getFirstName());
        existingStudent.setLastName(std.getLastName());
        existingStudent.setEmail(std.getEmail());
        existingStudent.setDob(std.getDob());
        studentProfileRepository.save(existingStudent);
        return existingStudent;
    }

    @Override
    public Long deleteById(Long id) {
        StudentProfile existingStudent=studentProfileRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","ID",id));

        studentProfileRepository.deleteById(existingStudent.getId());
        System.out.println(id+"is deleted");
        return null;
    }
}
