package com.fenton.rest_api.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static javax.swing.Action.DEFAULT;


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

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Column(name = "dob",nullable = false)
    private String dob;

    @Column(name = "gender",nullable = false)
    private String gender;

    @Column(name = "mobile_number",nullable = false)
    private Long mobileNumber;

    @Column(name = "alt_mob_number")
    private Long altMobileNumber;

    @Column(name = "father_name",nullable = false)
    private String fatherName;

    @Column(name = "father_mobile")
    private Long fatherMobile;

    @Column(name = "mother_name",nullable = false)
    private String motherName;

    @Column(name = "mother_mobile")
    private Long motherMobile;

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
    private Long currentBacklogs;

    @Column(name = "tot_back",nullable = false)
    private Long totalBacklogs;

    @Column(name="placement_status",columnDefinition = "VARCHAR(255) DEFAULT 'No'")
    private String placementStatus = "No";



//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL , mappedBy = "studentProfile")


}
