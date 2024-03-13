package com.fenton.rest_api.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "studentProfile")
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "middle_name",nullable = false)
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "dob",nullable = false)
    private String dob;
    @Column(name = "gender",nullable = false)
    private String gender;
    @Column(name = "mobile_number",nullable = false)
    private String mobileNumber;
    @Column(name = "alt_mob_number",nullable = false)
    private String altMobileNumber;
    @Column(name = "father_name",nullable = false)
    private String fatherName;
    @Column(name = "father_mobile",nullable = false)
    private String fatherMobile;
    @Column(name = "mother_name",nullable = false)
    private String motherName;
    @Column(name = "mother_mobile",nullable = false)
    private String motherMobile;
    @Column(name = "permanent_address",nullable = false)
    private String permanentAddress;
    @Column(name = "current_address",nullable = false)
    private String currentAddress;
    @Column(name = "class10th",nullable = false)
    private String class10grade;
    @Column(name = "class12th",nullable = false)
    private String class12grade;
    @Column(name = "curr_deg_grade",nullable = false)
    private String currentdegreegrade;
    @Column(name = "cpi",nullable = false)
    private String cpi;
    @Column(name = "curr_back",nullable = false)
    private String currentBacklogs;
    @Column(name = "tot_back",nullable = false)
    private String totalBacklogs;

//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL , mappedBy = "studentProfile")


}
