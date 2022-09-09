package com.clinic.hms.doctor.repository;

import com.clinic.hms.doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author akhilkanakendran
 * Interface for Data JPA
 */
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    /**
     * Find doctors matching the name
     *
     * @param name Name of the doctor
     * @return List of doctor matching the name
     */
    List<Doctor> findDoctorsByName(String name);
}