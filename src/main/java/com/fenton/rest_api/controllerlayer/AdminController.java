package com.fenton.rest_api.controllerlayer;

import com.fenton.rest_api.Model.*;
import com.fenton.rest_api.servicelayer.AdminService;
import com.fenton.rest_api.servicelayer.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService){
        this.adminService=adminService;
    }

    //repeated in student_profile
    @GetMapping("/getAllStudent")
    public List<StudentProfile> getAllStudent(){
        return adminService.getAllStudent();
    }
    @PostMapping("/addStudents")
    public ResponseEntity<StudentProfile> addStudents(@RequestBody StudentProfile studentProfile) {
        return new ResponseEntity<StudentProfile>(adminService.addStudent(studentProfile),HttpStatus.CREATED);
    }

    @PostMapping("/addStudentadmin")
    public ResponseEntity<AddStudent> addStudentadmin(@RequestBody AddStudent addStudent) {
        return new ResponseEntity<AddStudent>(adminService.addstudentadmin(addStudent),HttpStatus.CREATED);
    }

    @PostMapping("/addCompany")
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        return new ResponseEntity<Company>(adminService.addCompany(company),HttpStatus.CREATED);
    }
    @PostMapping("/postJob/{companyId}")
    public ResponseEntity<Job> postJob(@PathVariable Long companyId,@RequestBody Job job){
        return new ResponseEntity<Job>(adminService.postJob(companyId,job),HttpStatus.CREATED);
    }
    //repeated for admin and student itself
    @PutMapping("/updateStudent/{stdId}")
    public ResponseEntity<StudentProfile> updateStudent(@PathVariable Long stdId, @RequestBody StudentProfile studentProfile) {
        return new ResponseEntity<StudentProfile>(adminService.updateStudent(stdId,studentProfile),HttpStatus.OK);
    }
    @PutMapping("/updateJob/{jobId}")
    public ResponseEntity<Job> updateJob(@PathVariable Long jobId, @RequestBody Job job) {
        return new ResponseEntity<Job>(adminService.updateJob(jobId,job),HttpStatus.OK);
    }

    @PutMapping("/updateStudentadmin/{studentId}")
    public ResponseEntity<AddStudent> updateStudentadmin(@PathVariable Long studentId, @RequestBody AddStudent addStudent) {
        return new ResponseEntity<AddStudent>(adminService.updateStudentadmin(studentId,addStudent),HttpStatus.OK);
    }
}
