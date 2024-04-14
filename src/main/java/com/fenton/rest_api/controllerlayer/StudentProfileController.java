package com.fenton.rest_api.controllerlayer;

import com.fenton.rest_api.Model.Job;
import com.fenton.rest_api.Model.StudentProfile;
import com.fenton.rest_api.servicelayer.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<StudentProfile> getAllStudent(){
        return studentService.getAllStudentProfile();
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentProfile> getStudentById(@PathVariable("id")Long stdid){
        return new ResponseEntity<StudentProfile>(studentService.getStudentProfileById(stdid),HttpStatus.I_AM_A_TEAPOT);
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentProfile> updateStudent(@PathVariable("id")Long stdid,@RequestBody StudentProfile studentProfile){
        return new ResponseEntity<StudentProfile>(studentService.updateStudentProfile(stdid,studentProfile),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteStudent(@PathVariable("id")Long stdid){
        return new ResponseEntity<Long>(studentService.deleteById(stdid),HttpStatus.ACCEPTED);
    }

    @GetMapping("/appliedJobs/{student_id}")
    public ResponseEntity<List<Job>> getJobsByStudentId(@PathVariable("student_id") Long studentId) {
        List<Job> jobs = studentService.getJobsByStudentId(studentId);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @GetMapping("/getJobById/{jobId}")
    public ResponseEntity<Job> getJobById(@PathVariable("jobId")Long jobId){
        return new ResponseEntity<Job>(studentService.getJobById(jobId),HttpStatus.OK);
    }
    //it'll give the the job which is opened for hiring
    @GetMapping("/getAllOpenJobs")
    public ResponseEntity<List<Job>> getAllOpenJobs(){
        List<Job> jobs=studentService.getAllOpenJobs();
        return new ResponseEntity<>(jobs,HttpStatus.OK);
    }





}
