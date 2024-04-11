package com.fenton.rest_api.servicelayer;

import com.fenton.rest_api.Model.Admin;
import com.fenton.rest_api.Model.HR;
import com.fenton.rest_api.Model.LoginCredentials;
import com.fenton.rest_api.Model.StudentProfile;
import com.fenton.rest_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
    private AdminRepository adminRepository;
    private CompanyRepository companyRepository;
    private HRRepository hrRepository;
    private JobRepository jobRepository;
    private StudentProfileRepository studentProfileRepository;
    @Autowired
    public AuthenticationServiceImpl(AdminRepository adminRepository,CompanyRepository companyRepository,HRRepository hrRepository,JobRepository jobRepository,StudentProfileRepository studentProfileRepository){
        this.adminRepository=adminRepository;
        this.companyRepository=companyRepository;
        this.hrRepository=hrRepository;
        this.jobRepository=jobRepository;
        this.studentProfileRepository=studentProfileRepository;
    }
    @Override
    public Object login(LoginCredentials loginInfo) {
        if (loginInfo.getEmail() == "" || loginInfo.getPassword() == "") {
            return "Cannot log in. Please enter both email and password.";
        }

        Optional<Admin> adminOptional = adminRepository.findByEmail(loginInfo.getEmail());
        Optional<HR> hrOptional = hrRepository.findByEmail(loginInfo.getEmail());
        Optional<StudentProfile> studentProfileOptional = studentProfileRepository.findByEmail(loginInfo.getEmail());
        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();
            if (admin.getPassword().equals(loginInfo.getPassword())) {
                // Successful login, return admin information
                //return "Logged in successfully: Your Email is : "+admin.getEmail();
                return admin;

            } else {
                return "Incorrect Email or password";
            }
        }
        else if (hrOptional.isPresent()) {
            HR hr = hrOptional.get();
            if (hr.getPassword().equals(loginInfo.getPassword())) {
                // Successful login, return admin information
                return hr;

            } else {
                return "Email or password is incorrect.";
            }
        }

        else if (studentProfileOptional.isPresent()) {
            StudentProfile student = studentProfileOptional.get();
            if (student.getEmail()==null || student.getPassword()==null){
                return "Cannot log in. Please enter both email and password.";
            }

            else{
                if (student.getPassword().equals(loginInfo.getPassword())) {
                    // Successful login, return admin information
                    return student;

                } else {
                    return "Email or password is incorrect.";
                }
            }
        } else {
            return "You are not registered. First register, then log in here.";
        }
    }
}
