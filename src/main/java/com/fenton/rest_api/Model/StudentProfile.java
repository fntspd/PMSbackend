package com.fenton.rest_api.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;


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

    @Column(name = "dob")
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

    @Column(name = "permanent_address")
    private String permanentAddress;

    @Column(name = "current_address")
    private String currentAddress;

    @Column(name = "class10th")
    private String class10grade;

    @Column(name = "class12th")
    private String class12grade;

    @Column(name = "curr_deg_grade")
    private String currentdegreegrade;

    @Column(name = "cpi")
    private String cpi;

    @Column(name = "curr_back")
    private Long currentBacklogs;

    @Column(name = "tot_back")
    private Long totalBacklogs;

    @Column(name="placement_status",columnDefinition = "VARCHAR(255) DEFAULT 'No'")
    private String placementStatus = "No";


//    @Transient // Exclude from database mapping
//    private MultipartFile profileIconFile;
//
//    @Column(name = "profile_icon") // Store Base64 encoded content in database
//    private String profileIconBase64;
//
//    public void setProfileIconFile(MultipartFile profileIconFile) {
//        this.profileIconFile = profileIconFile;
//        if (profileIconFile != null) {
//            try {
//                this.profileIconBase64 = Base64.getEncoder().encodeToString(profileIconFile.getBytes());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Long getAltMobileNumber() {
        return altMobileNumber;
    }

    public void setAltMobileNumber(Long altMobileNumber) {
        this.altMobileNumber = altMobileNumber;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Long getFatherMobile() {
        return fatherMobile;
    }

    public void setFatherMobile(Long fatherMobile) {
        this.fatherMobile = fatherMobile;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Long getMotherMobile() {
        return motherMobile;
    }

    public void setMotherMobile(Long motherMobile) {
        this.motherMobile = motherMobile;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getClass10grade() {
        return class10grade;
    }


//    @Transient // Exclude from database mapping
//    private MultipartFile class10thFile;
//
//    @Transient // Exclude from database mapping
//    private MultipartFile class12thFile;
//    public void setClass10grade(MultipartFile class10thFile) {
//        this.class10grade = class10grade;
//        if (class12thFile != null) {
//            try {
//                this.class10grade = Base64.getEncoder().encodeToString(class10thFile.getBytes());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public String getClass12grade() {
//        return class12grade;
//    }
//
//    public void setClass12grade(MultipartFile class12thFile) {
//        this.class10grade = class10grade;
//        if (class12thFile != null) {
//            try {
//                this.class12grade = Base64.getEncoder().encodeToString(class12thFile.getBytes());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public String getCurrentdegreegrade() {
        return currentdegreegrade;
    }

    public void setCurrentdegreegrade(String currentdegreegrade) {
        this.currentdegreegrade = currentdegreegrade;
    }

    public String getCpi() {
        return cpi;
    }

    public void setCpi(String cpi) {
        this.cpi = cpi;
    }

    public Long getCurrentBacklogs() {
        return currentBacklogs;
    }

    public void setCurrentBacklogs(Long currentBacklogs) {
        this.currentBacklogs = currentBacklogs;
    }

    public Long getTotalBacklogs() {
        return totalBacklogs;
    }

    public void setTotalBacklogs(Long totalBacklogs) {
        this.totalBacklogs = totalBacklogs;
    }

    public String getPlacementStatus() {
        return placementStatus;
    }

    public void setPlacementStatus(String placementStatus) {
        this.placementStatus = placementStatus;
    }

//    public MultipartFile getProfileIconFile() {
//        return profileIconFile;
//    }
//
//    public String getProfileIconBase64() {
//        return profileIconBase64;
//    }
//
//    public void setProfileIconBase64(String profileIconBase64) {
//        this.profileIconBase64 = profileIconBase64;
//    }
//
//    public MultipartFile getClass10thFile() {
//        return class10thFile;
//    }
//
//    public MultipartFile getClass12thFile() {
//        return class12thFile;
//    }

//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL , mappedBy = "studentProfile")


}
