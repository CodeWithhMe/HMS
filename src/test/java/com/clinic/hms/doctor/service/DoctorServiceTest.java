package com.clinic.hms.doctor.service;

import com.clinic.hms.doctor.entity.Doctor;
import com.clinic.hms.doctor.repository.DoctorRepository;
import com.clinic.hms.exception.HMSException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;
    private DoctorService doctorService;

    @BeforeEach
    void setUp() {
        doctorService = new DoctorService(doctorRepository);
    }

    /**
     * Checks whether doctor repository
     * was invoked with the same doctor
     * that we passed
     */
    @Test
    void canAddNewDoctor() {
        //given
        Doctor doctor = new Doctor(
                "Akhil",
                "18-06-1990",
                "MBBS",
                "Cardiologist",
                "Cardiology",
                "500"
        );
        //when
        doctorService.addDoctor(doctor);
        //then
        ArgumentCaptor<Doctor> doctorArgumentCaptor =
                ArgumentCaptor.forClass(Doctor.class);
        verify(doctorRepository).save(doctorArgumentCaptor.capture());
        Doctor capturedDoctor = doctorArgumentCaptor.getValue();
        assertThat(capturedDoctor).isEqualTo(doctor);
    }

    /**
     * Checks whether findAll() method
     * is invoked from DoctorService
     */
    @Test
    void canFindAllDoctors() {
        //when
        doctorService.findAllDoctors();
        //then
        verify(doctorRepository).findAll();
    }

    /**
     * Checks whether an exception is thrown
     * and no save is made when
     * same doctor details are submitted for registration
     */
    @Test
    void willThrowWhenSameDoctorExists() {
        //given
        Doctor doctor = new Doctor(
                "Akhil",
                "18-06-1990",
                "MBBS",
                "Cardiologist",
                "Cardiology",
                "500"
        );
        given(doctorRepository.selectDoctorNameAndDOBExists(
                doctor.getName(),
                doctor.getDateOfBirth()))
                .willReturn(true);
        //when
        //then
        assertThatThrownBy(() -> doctorService.addDoctor(doctor))
                .isInstanceOf(HMSException.class)
                .hasMessageContaining("Doctor "
                        + doctor.getName()
                        + " with "
                        + doctor.getDateOfBirth()
                        + " taken");

        verify(doctorRepository, never()).save(any());

    }
}