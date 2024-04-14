package com.fenton.rest_api.servicelayer;

import com.fenton.rest_api.FieldsNotEnteredException;
import com.fenton.rest_api.Model.*;
import com.fenton.rest_api.ResourceNotFoundException;
import com.fenton.rest_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    private AdminRepository adminRepository;
    private CompanyRepository companyRepository;
    private HRRepository hrRepository;
    private JobRepository jobRepository;
    private StudentProfileRepository studentProfileRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository,CompanyRepository companyRepository,HRRepository hrRepository,JobRepository jobRepository,StudentProfileRepository studentProfileRepository) {
        this.adminRepository = adminRepository;
        this.companyRepository = companyRepository;
        this.hrRepository=hrRepository;
        this.jobRepository=jobRepository;
        this.studentProfileRepository=studentProfileRepository;
    }

    @Override
    public Admin admin(Admin admin) {
        return null;
    }


    @Override
    public List<StudentProfile> getAllStudent() {
        return studentProfileRepository.findAll();
    }
    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }
    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
    @Override
    public StudentProfile addStudent(StudentProfile studentProfile){
        if (studentProfile.getFirstName() == null ||
                studentProfile.getLastName() == null ||
                studentProfile.getMiddleName()== null ||
                studentProfile.getEmail() == null ||
                studentProfile.getCampus() == null ||
                studentProfile.getBranch() == null ||
                studentProfile.getSchool() == null ||
                studentProfile.getDob() == null ||
                studentProfile.getGender() == null ||
                studentProfile.getMobileNumber() == null ||
                studentProfile.getClass10grade() == null ||
                studentProfile.getClass12grade() == null ||
                studentProfile.getFatherName() == null ||
                studentProfile.getMotherName() == null ||
                studentProfile.getPermanentAddress() == null ||
                studentProfile.getCurrentAddress() == null ||
                studentProfile.getCurrentBacklogs() == null ||
                studentProfile.getCurrentdegreegrade() == null ||
                studentProfile.getCpi() == null ||
                studentProfile.getTotalBacklogs() == null) {
            throw new FieldsNotEnteredException();
        }

        return studentProfileRepository.save(studentProfile);
    }

    @Override
    public Company addCompany(Company company){
        if(company.getName()==null||company.getLocation()==null||company.getDescription()==null||company.getIndustry()==null||company.getHr().getEmail()==null||company.getHr().getFirstName()==null||company.getHr().getLastName()==null){
            throw new FieldsNotEnteredException();
        }
        hrRepository.save(company.getHr());
        return companyRepository.save(company);

    }
    @Override
    public Job postJob(Long companyId,Job job){
        //job will b posted only when there will be company associated with it or already registered with it
        Company company=companyRepository.findById(companyId).orElseThrow(()-> new ResourceNotFoundException("Company","ID",companyId));
        if(job.getTitle()==null||
                job.getRequirements()==null||
                job.getDescription()==null
        ){
            throw new FieldsNotEnteredException();
        }

        job.setCompany(company);
        return jobRepository.save(job);

    }
    @Override
    public StudentProfile updateStudent(Long stdId, StudentProfile studentProfile){
        StudentProfile existingStudent=studentProfileRepository.findById(stdId).orElseThrow(()->new ResourceNotFoundException("Student","ID",stdId));
        if (studentProfile.getFirstName() != null) {
            existingStudent.setFirstName(studentProfile.getFirstName());
        }
        if (studentProfile.getMiddleName() != null) {
            existingStudent.setMiddleName(studentProfile.getMiddleName());
        }
        if (studentProfile.getLastName() != null) {
            existingStudent.setLastName(studentProfile.getLastName());
        }
        if (studentProfile.getEmail() != null) {
            existingStudent.setEmail(studentProfile.getEmail());
        }
        if (studentProfile.getPassword() != null) {
            existingStudent.setPassword(studentProfile.getPassword());
        }
        if (studentProfile.getSchool() != null) {
            existingStudent.setSchool(studentProfile.getSchool());
        }
        if (studentProfile.getCampus() != null) {
            existingStudent.setCampus(studentProfile.getCampus());
        }
        if (studentProfile.getBranch() != null) {
            existingStudent.setBranch(studentProfile.getBranch());
        }
        if (studentProfile.getDob() != null) {
            existingStudent.setDob(studentProfile.getDob());
        }
        if (studentProfile.getGender() != null) {
            existingStudent.setGender(studentProfile.getGender());
        }
        if (studentProfile.getMobileNumber() != null) {
            existingStudent.setMobileNumber(studentProfile.getMobileNumber());
        }
        if (studentProfile.getAltMobileNumber() != null) {
            existingStudent.setAltMobileNumber(studentProfile.getAltMobileNumber());
        }
        if (studentProfile.getFatherName() != null) {
            existingStudent.setFatherName(studentProfile.getFatherName());
        }
        if (studentProfile.getFatherMobile() != null) {
            existingStudent.setFatherMobile(studentProfile.getFatherMobile());
        }
        if (studentProfile.getMotherName() != null) {
            existingStudent.setMotherName(studentProfile.getMotherName());
        }
        if (studentProfile.getMotherMobile() != null) {
            existingStudent.setMotherMobile(studentProfile.getMotherMobile());
        }
        if (studentProfile.getPermanentAddress() != null) {
            existingStudent.setPermanentAddress(studentProfile.getPermanentAddress());
        }
        if (studentProfile.getCurrentAddress() != null) {
            existingStudent.setCurrentAddress(studentProfile.getCurrentAddress());
        }
        if (studentProfile.getClass10grade() != null) {
            existingStudent.setClass10grade(studentProfile.getClass10grade());

        }if (studentProfile.getClass12grade() != null) {
            existingStudent.setClass12grade(studentProfile.getClass12grade());
        }
        if (studentProfile.getCurrentdegreegrade() != null) {
            existingStudent.setCurrentdegreegrade(studentProfile.getCurrentdegreegrade());
        }
        if (studentProfile.getCpi() != null) {
            existingStudent.setCpi(studentProfile.getCpi());
        }
        if (studentProfile.getCurrentBacklogs() != null) {
            existingStudent.setCurrentBacklogs(studentProfile.getCurrentBacklogs());
        }
        if (studentProfile.getTotalBacklogs() != null) {
            existingStudent.setTotalBacklogs(studentProfile.getTotalBacklogs());
        }
        if (studentProfile.getPlacementStatus() != null) {
            existingStudent.setPlacementStatus(studentProfile.getPlacementStatus());
        }
        studentProfileRepository.save(existingStudent);
        return existingStudent;

        //return studentProfileRepository.save(studentProfile);
    }
    @Override
    public Job updateJob(Long jobId,Job job){
        Job existingJob=jobRepository.findById(jobId).orElseThrow(()->new ResourceNotFoundException("Job","ID",jobId));
        if (job.getTitle() != null) {
            existingJob.setTitle(job.getTitle());
        }
        if (job.getRequirements() != null) {
            existingJob.setRequirements(job.getRequirements());
        }
        if (job.getDescription() != null) {
            existingJob.setDescription(job.getDescription());
        }
        jobRepository.save(existingJob);
        return existingJob;
    }
    @Override
    public Long deleteJobById(Long jobId) {
        Job existingJob=jobRepository.findById(jobId).orElseThrow(()-> new ResourceNotFoundException("Job","ID",jobId));
        existingJob.setCompany(null);
        jobRepository.deleteById(existingJob.getId());
        System.out.println(jobId+"is deleted");
        return null;
    }
}
