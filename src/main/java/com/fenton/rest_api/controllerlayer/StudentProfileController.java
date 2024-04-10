package com.fenton.rest_api.controllerlayer;

import com.fenton.rest_api.Model.StudentProfile;
import com.fenton.rest_api.repository.StudentProfileRepository;
import com.fenton.rest_api.servicelayer.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/studentprofile")
public class StudentProfileController {

    private StudentService studentService;

    @Autowired
    public StudentProfileController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping
    public ResponseEntity<StudentProfile> saveStd(@RequestBody StudentProfile studentProfile) {
        return new ResponseEntity<StudentProfile>(studentService.saveStudentProfile(studentProfile),HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentProfile> updateStudent(@PathVariable("id")Long stdid,@RequestBody StudentProfile studentProfile){
        return new ResponseEntity<StudentProfile>(studentService.updateStudentProfile(stdid,studentProfile),HttpStatus.OK);
    }

}
