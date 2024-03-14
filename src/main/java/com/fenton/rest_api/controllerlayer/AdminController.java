package com.fenton.rest_api.controllerlayer;

import com.fenton.rest_api.Model.HR;
import com.fenton.rest_api.Model.StudentProfile;
import com.fenton.rest_api.servicelayer.AdminService;
import com.fenton.rest_api.servicelayer.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService){
        this.adminService=adminService;
    }

    @PostMapping("/addStudents")
    public ResponseEntity<Object> addStudents(@RequestBody StudentProfile studentProfile) {
        Object saveStudent = adminService.addStudent(studentProfile);
        if (saveStudent instanceof String) {
            return new ResponseEntity<>(saveStudent, HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);
        }
    }
    @PostMapping("/addHr")
    public ResponseEntity<Object> addHr(@RequestBody HR hr) {
        Object saveStudent = adminService.addHr(hr);
        if (saveStudent instanceof String) {
            return new ResponseEntity<>(saveStudent, HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);
        }
    }

}
