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
//    @OneToOne
//    @JoinColumn(name = "hr_id")         //foreign key
//    private HR hr;
}
