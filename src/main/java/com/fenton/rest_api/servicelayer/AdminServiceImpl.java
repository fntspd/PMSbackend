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
    private  AddStudentRepository addStudentRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository,CompanyRepository companyRepository,HRRepository hrRepository,JobRepository jobRepository,StudentProfileRepository studentProfileRepository,AddStudentRepository addStudentRepository) {
        this.adminRepository = adminRepository;
        this.companyRepository = companyRepository;
        this.hrRepository=hrRepository;
        this.jobRepository=jobRepository;
        this.studentProfileRepository=studentProfileRepository;
        this.addStudentRepository=addStudentRepository;
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
    public StudentProfile addStudent(StudentProfile studentProfile){
        if (studentProfile.getFirstName() == null ||
                studentProfile.getLastName() == null ||
                studentProfile.getEmail() == null ||
                studentProfile.getCpi() == null ||
                studentProfile.getMobileNumber() == null ||
                studentProfile.getDob() == null ||
                studentProfile.getGender() == null ||
                studentProfile.getFatherName() == null ||
                studentProfile.getMotherName() == null ||
                studentProfile.getPermanentAddress() == null ||
                studentProfile.getCurrentAddress() == null ||
                studentProfile.getClass10grade() == null ||
                studentProfile.getClass12grade() == null ||
                studentProfile.getCurrentdegreegrade() == null ||
                studentProfile.getCurrentBacklogs() == null ||
                studentProfile.getTotalBacklogs() == null) {
            throw new FieldsNotEnteredException();
        }

        return studentProfileRepository.save(studentProfile);
    }

    @Override
    public AddStudent addstudentadmin(AddStudent addStudent) {
        if(addStudent.getStudentName()==null||addStudent.getSchool()==null||addStudent.getCampus()==null||addStudent.getBranch()==null||addStudent.getEmail()==null){
            throw new FieldsNotEnteredException();
        }
        return addStudentRepository.save(addStudent);
    }

    @Override
    public AddStudent updateStudentadmin(Long studentId, AddStudent addStudent) {
        AddStudent existingStudentadmin=addStudentRepository.findById(studentId).orElseThrow(()->new ResourceNotFoundException("Student","ID",studentId));
        if (addStudent.getStudentName() != null) {
            existingStudentadmin.setStudentName(addStudent.getStudentName());
        }
        if (addStudent.getSchool() != null) {
            existingStudentadmin.setSchool(addStudent.getSchool());
        }
        if (addStudent.getCampus() != null) {
            existingStudentadmin.setCampus(addStudent.getCampus());
        }
        if (addStudent.getBranch() != null) {
            existingStudentadmin.setBranch(addStudent.getBranch());
        }if (addStudent.getEmail() != null) {
            existingStudentadmin.setEmail(addStudent.getEmail());
        }
        if (addStudent.getPassword() != null) {
            existingStudentadmin.setPassword(addStudent.getPassword());
        }
        addStudentRepository.save(existingStudentadmin);
        return existingStudentadmin;
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
        //job will b posted only when there will b company associated with it or already registered with it
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
}
