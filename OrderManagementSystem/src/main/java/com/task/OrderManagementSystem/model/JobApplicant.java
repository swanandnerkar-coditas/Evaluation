package com.task.OrderManagementSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Job_applicant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobApplicant {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "skill")
    private String skills;

    @Column(name = "experience")
    private int experience;

    @Column(name = "education")
    private String education;

    @Column(name = "resumeText")
    private String resumeText;
}
