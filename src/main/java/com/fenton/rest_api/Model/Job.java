package com.fenton.rest_api.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "requirements",nullable = false)
    private String requirements;
    //job location or campus
    @ManyToOne
    @JoinColumn(name = "company_id",nullable = false)      //foreign key
    private Company company;

    @Column(nullable = false, columnDefinition = "varchar(255) default 'Open'")
    private String status="Open";

    @ManyToMany(mappedBy = "jobs")
    @JsonIgnore
    private List<StudentProfile> studentProfile;


//    @OneToOne
//    @JoinColumn(name = "hr_id")         //foreign key
//    private HR hr;
}