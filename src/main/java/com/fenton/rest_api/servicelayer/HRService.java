package com.fenton.rest_api.servicelayer;

import com.fenton.rest_api.Model.Job;

import java.util.List;

public interface HRService {
    List<Job> getPostedJob(Long hrId);
    Job postJob(Long companyId,Job job);
}
