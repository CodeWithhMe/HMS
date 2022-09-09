package com.clinic.hms.doctor.repository;

import com.clinic.hms.doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findDoctorsByName(String name);
}