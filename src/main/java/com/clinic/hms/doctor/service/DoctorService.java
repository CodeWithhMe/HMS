package com.clinic.hms.doctor.service;

import com.clinic.hms.doctor.entity.Doctor;
import com.clinic.hms.doctor.repository.DoctorRepository;
import com.clinic.hms.exception.HMSException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author akhilkanakendran
 * Implementation class for the rest operations
 * on Doctor module
 */
@AllArgsConstructor
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    /**
     * Add new doctor passed from the Controller
     * The new doctor is persisted into the database
     *
     * @param doctor New doctor Entity
     */
    public void addDoctor(Doctor doctor) {
        Boolean doctorExists =
                doctorRepository.selectDoctorNameAndDOBExists(
                        doctor.getName(),
                        doctor.getDateOfBirth());
        if (doctorExists) {
            throw new HMSException("Doctor "
                    + doctor.getName()
                    + " with "
                    + doctor.getDateOfBirth()
                    + " taken");
        }
        doctorRepository.save(doctor);
    }

    /**
     * Find list of all doctors
     *
     * @return List of Doctors
     */
    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }
}
