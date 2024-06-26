package com.fenton.rest_api.controllerlayer;

import com.fenton.rest_api.Model.Company;
import com.fenton.rest_api.Model.HR;
import com.fenton.rest_api.Model.Job;
import com.fenton.rest_api.Model.StudentProfile;
import com.fenton.rest_api.servicelayer.AdminService;
import com.fenton.rest_api.servicelayer.JobService;
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

    @GetMapping("/getAllCompany")
    public List<Company> getAllCompany(){
        return adminService.getAllCompany();
    }
    @GetMapping("/getAllJobs")
    public List<Job> getAllJobs(){
        return adminService.getAllJobs();
    }
    //can be repeated with hrcontroller so ,have to make it single controller
    @PostMapping("/addStudents")
    public ResponseEntity<StudentProfile> addStudents(@RequestBody StudentProfile studentProfile) {
        return new ResponseEntity<StudentProfile>(adminService.addStudent(studentProfile),HttpStatus.CREATED);
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
    @PutMapping("/updateJob/{jobId}/{companyId}")
    public ResponseEntity<Job> updateJob(@PathVariable Long jobId, @PathVariable Long companyId,@RequestBody Job job) {
        return new ResponseEntity<Job>(adminService.updateJob(jobId,companyId,job),HttpStatus.OK);
    }
    @DeleteMapping("/deleteJob/{jobId}")
    public ResponseEntity<Long> deleteJobById(@PathVariable("jobId")Long jobId){
        return new ResponseEntity<Long>(adminService.deleteJobById(jobId),HttpStatus.OK);
    }
}
