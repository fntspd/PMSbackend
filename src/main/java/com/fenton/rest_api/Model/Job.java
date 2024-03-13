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
@Table(name = "admin")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "requirements")
    private String requirements;
    @ManyToOne
    @Column(name = "company_id")       //foreign key
    private Company companyId;
    @OneToOne
    @Column(name = "hr_id")           //foreign key
    private HR hrId;
}
