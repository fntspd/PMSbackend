package com.fenton.rest_api.servicelayer;

import com.fenton.rest_api.Model.Admin;
import com.fenton.rest_api.Model.HR;
import com.fenton.rest_api.Model.StudentProfile;
import com.fenton.rest_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Object addStudent(StudentProfile studentProfile){
        if(studentProfile.getFirstName()==null||
                studentProfile.getLastName()==null||
                studentProfile.getEmail()==null||
                studentProfile.getCpi()==null||
                studentProfile.getAltMobileNumber()==null||
                studentProfile.getMobileNumber()==null||
                studentProfile.getDob()==null||
                studentProfile.getGender()==null||
                studentProfile.getMobileNumber()==null||
                studentProfile.getFatherName()==null||
                studentProfile.getFatherMobile()==null||
                studentProfile.getMotherName()==null||
                studentProfile.getMotherMobile()==null||
                studentProfile.getPermanentAddress()==null||
                studentProfile.getCurrentAddress()==null||
                studentProfile.getClass10grade()==null||
                studentProfile.getClass12grade()==null||
                studentProfile.getCurrentdegreegrade()==null||
                studentProfile.getCurrentBacklogs()==null||
                studentProfile.getTotalBacklogs()==null
        ){
             return "Please enter all the fields";
        }
        return studentProfileRepository.save(studentProfile);
    }


    @Override
    public Object addHr(HR hr){
        return hrRepository.save(hr);
    }
}
