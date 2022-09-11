package com.clinic.hms.doctor.service;

import com.clinic.hms.doctor.entity.Doctor;
import com.clinic.hms.doctor.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author akhilkanakendran
 * Implementation class for the rest operations
 * on Doctor module
 */
@RequiredArgsConstructor
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    /**
     * Add new doctor passed from the Controller
     * The new doctor is persisted into the database
     *
     * @param doctor New doctor Entity
     */
    public void save(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    /**
     * Find list of all doctors
     *
     * @return List of Doctors
     */
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

}
