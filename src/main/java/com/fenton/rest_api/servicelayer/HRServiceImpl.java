package com.fenton.rest_api.servicelayer;

import com.fenton.rest_api.FieldsNotEnteredException;
import com.fenton.rest_api.ResourceNotFoundException;
import com.fenton.rest_api.Model.Company;
import com.fenton.rest_api.Model.Job;
import com.fenton.rest_api.Model.StudentProfile;
import com.fenton.rest_api.ResourceNotFoundException;
import com.fenton.rest_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HRServiceImpl implements HRService{
    private AdminRepository adminRepository;
    private CompanyRepository companyRepository;
    private HRRepository hrRepository;
    private JobRepository jobRepository;
    private StudentProfileRepository studentProfileRepository;
    @Autowired
    public HRServiceImpl(AdminRepository adminRepository,CompanyRepository companyRepository,HRRepository hrRepository,JobRepository jobRepository,StudentProfileRepository studentProfileRepository) {
        this.adminRepository = adminRepository;
        this.companyRepository = companyRepository;
        this.hrRepository=hrRepository;
        this.jobRepository=jobRepository;
        this.studentProfileRepository=studentProfileRepository;
    }
    @Override
    public List<Job> getPostedJob(Long hrId) {
        // Find the company associated with the HR id
        Company company = companyRepository.findCompanyByHrId_Id(hrId);

        // Get all jobs associated with the found company id
        //return jobRepository.findByCompanyId(companyId);
        return jobRepository.findByCompany(company);
    }
    @Override
    public Job postJob(Long hrId,Job job){
        //job will b posted only when there will b company associated with it or already registered with it
        Company company=companyRepository.findCompanyByHrId_Id(hrId);
//        if (company == null) {
//            throw new ResourceNotFoundException("HR", "ID", hrId);
//        }
        if(job.getTitle()==null||
                job.getRequirements()==null||
                job.getDescription()==null
        ){
            throw new FieldsNotEnteredException();
        }
        job.setCompany(company);
        return jobRepository.save(job);
    }
}
