package com.clinic.hms.doctor.repository;

import com.clinic.hms.doctor.entity.Doctor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test Cases for the DoctorRepository Interface
 */
@DataJpaTest
class DoctorRepositoryTest {

    @Autowired
    private DoctorRepository doctorRepository;

    /**
     * Unit Test Case to find doctors by Name
     */
    @Test
    void canFindDoctorsByName() {
        //given
        var doctorName = "Akhil";
        Doctor doctor1 = new Doctor("Akhil", "18-06-1990", "MBBS", "Cardiologist", "Cardiology", "500");
        doctorRepository.save(doctor1);

        Doctor doctor2 = new Doctor("Akhil", "20-10-1990", "MD", "Dermatologist", "Dermatology", "300");
        doctorRepository.save(doctor2);

        Doctor doctor3 = new Doctor("Kinara", "25-09-1993", "BPT", "Physiotherapist", "Physiotherapy", "500");
        doctorRepository.save(doctor3);

        //when
        List<Doctor> expectedDoctors = doctorRepository.findDoctorsByName(doctorName);

        //then
        assertThat(expectedDoctors).hasSize(2).contains(doctor1, doctor2);
    }
}