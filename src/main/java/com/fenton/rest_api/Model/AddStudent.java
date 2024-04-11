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
    @Table(name = "addStudent")
    public class AddStudent {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "student_name", nullable = false)
        private String studentName;
        @Column(name = "school", nullable = false)
        private String school;
        @Column(name = "campus", nullable = false)
        private String campus;
        @Column(name = "branch",nullable = false)
        private  String branch;
        @Column(name = "email", nullable = false, unique = true)
        private String email;
        @Column(name = "password", nullable = false )
        private  String password;
    }
