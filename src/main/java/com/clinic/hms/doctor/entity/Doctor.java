package com.clinic.hms.doctor.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "qualification")
    private String qualification;
    @Column(name = "designation")
    private String designation;
    @Column(name = "department")
    private String department;
    @Column(name = "consultationFee")
    private String consultationFee;

    public Doctor(String name, String qualification, String designation, String department, String consultationFee) {
        this.name = name;
        this.qualification = qualification;
        this.designation = designation;
        this.department = department;
        this.consultationFee = consultationFee;
    }
}
