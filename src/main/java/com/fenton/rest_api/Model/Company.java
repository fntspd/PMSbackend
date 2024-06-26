package com.fenton.rest_api.Model;

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
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false,unique = true)
    private String name;

    @Column(name = "industry")
    private String industry;

    @Column(name = "location",nullable = false)
    private String location;

    @Column(name = "description",nullable = false)
    private String description;

    @OneToOne
    @JoinColumn(name = "hr_id",nullable = false)
    private HR hr;

}
