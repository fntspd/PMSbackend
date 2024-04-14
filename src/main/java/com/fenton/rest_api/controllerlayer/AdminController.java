package com.fenton.rest_api.controllerlayer;

import com.fenton.rest_api.Model.Company;
import com.fenton.rest_api.Model.HR;
import com.fenton.rest_api.Model.Job;
import com.fenton.rest_api.Model.StudentProfile;
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
        // Set default values for non-filled fields
        if (studentProfile.getFirstName() == null) {
            studentProfile.setFirstName("Default First Name");
        }
        if (studentProfile.getMiddleName() == null) {
            studentProfile.setMiddleName("Default Middle Name");
        }
        if (studentProfile.getLastName() == null) {
            studentProfile.setLastName("Default Last Name");
        }
        if (studentProfile.getEmail() == null) {
            studentProfile.setEmail("default_email@example.com");
        }
        if (studentProfile.getPassword() == null) {
            studentProfile.setPassword("defaultPassword123");
        }
        if (studentProfile.getSchool() == null) {
            studentProfile.setSchool("Default School");
        }
        if (studentProfile.getCampus() == null) {
            studentProfile.setCampus("Default Campus");
        }
        if (studentProfile.getBranch() == null) {
            studentProfile.setBranch("Default Branch");
        }
        if (studentProfile.getDob() == null) {
            studentProfile.setDob("01/01/2000");
        }
        if (studentProfile.getGender() == null) {
            studentProfile.setGender("Male");
        }
        if (studentProfile.getMobileNumber() == null) {
            studentProfile.setMobileNumber(1234567890L);
        }
        if (studentProfile.getFatherName() == null) {
            studentProfile.setFatherName("Default Father's Name");
        }
        if (studentProfile.getFatherMobile() == null) {
            studentProfile.setFatherMobile(9876543210L);
        }
        if (studentProfile.getMotherName() == null) {
            studentProfile.setMotherName("Default Mother's Name");
        }
        if (studentProfile.getMotherMobile() == null) {
            studentProfile.setMotherMobile(8765432109L);
        }
        if (studentProfile.getPermanentAddress() == null) {
            studentProfile.setPermanentAddress("Default Permanent Address");
        }
        if (studentProfile.getCurrentAddress() == null) {
            studentProfile.setCurrentAddress("Default Current Address");
        }
        if (studentProfile.getClass10grade() == null) {
            studentProfile.setClass10grade("A+");
        }
        if (studentProfile.getClass12grade() == null) {
            studentProfile.setClass12grade("A");
        }
        if (studentProfile.getCurrentdegreegrade() == null) {
            studentProfile.setCurrentdegreegrade("B");
        }
        if (studentProfile.getCpi() == null) {
            studentProfile.setCpi("8.5"); // Default CPI
        }
        if (studentProfile.getCurrentBacklogs() == null) {
            studentProfile.setCurrentBacklogs(0L);
        }
        if (studentProfile.getTotalBacklogs() == null) {
            studentProfile.setTotalBacklogs(0L);
        }
        if (studentProfile.getPlacementStatus() == null) {
            studentProfile.setPlacementStatus("No");
        }
        if (studentProfile.getCode() == null) {
            studentProfile.setCode("student");
        }

        StudentProfile addedStudent = adminService.addStudent(studentProfile);

        return new ResponseEntity<>(addedStudent, HttpStatus.CREATED);
    }

    @PostMapping("/addCompany")
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        return new ResponseEntity<Company>(adminService.addCompany(company),HttpStatus.CREATED);
    }

    @GetMapping("/getAllCompany")
    public List<Company> getAllCompany(){
        return adminService.getAllCompany();
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
}
