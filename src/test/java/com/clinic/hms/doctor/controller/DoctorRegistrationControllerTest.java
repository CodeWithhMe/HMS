package com.clinic.hms.doctor.controller;

import com.clinic.hms.doctor.dto.DoctorDTO;
import com.clinic.hms.doctor.mapper.DoctorMapper;
import com.clinic.hms.doctor.service.DoctorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DoctorRegistrationControllerTest {

    private DoctorRegistrationController doctorRegistrationController;

    @Mock
    private DoctorService doctorService;
    @Mock
    private DoctorMapper doctorMapper;

    @BeforeEach
    void setUp() {
        doctorRegistrationController = new DoctorRegistrationController(doctorService, doctorMapper);
    }

    @Test
    void canFindAllDoctors() {
        //given
        //when
        ResponseEntity<List<DoctorDTO>> responseEntity = doctorRegistrationController.findAllDoctors();
        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void canAddNewDoctor() {
        //given
        String uri = "/doctors";
        DoctorDTO doctor = new DoctorDTO(
                "Akhil",
                "18-06-1990",
                "MBBS",
                "Cardiologist",
                "Cardiology",
                "500"
        );
        //when
        ResponseEntity<DoctorDTO> doctorDTOResponseEntity = doctorRegistrationController.addNewDoctor(doctor);
        //then
        assertThat(doctorDTOResponseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }
}