package com.fenton.rest_api.controllerlayer;

import com.fenton.rest_api.Model.Job;
import com.fenton.rest_api.servicelayer.AdminService;
import com.fenton.rest_api.servicelayer.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/hr")
public class HrController {
    private HRService hrService;
    @Autowired
    public HrController(HRService hrService){
        this.hrService=hrService;
    }
    @GetMapping("/postedJob/{hrId}")
    public ResponseEntity<List<Job>> getPostedJob(@PathVariable Long hrId){
        //return new ResponseEntity<List<Job>>(hrService.getPostedJob(hrId), HttpStatus.OK);
        List<Job> postedJobs = hrService.getPostedJob(hrId);
        if (postedJobs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(postedJobs, HttpStatus.OK);
    }

    @PostMapping("/postJob/{hrId}")
    public ResponseEntity<Job> postJob(@PathVariable Long hrId,@RequestBody Job job){
        return new ResponseEntity<Job>(hrService.postJob(hrId,job),HttpStatus.CREATED);
    }

}
