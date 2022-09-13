package com.clinic.hms.doctor.mapper;

import com.clinic.hms.doctor.dto.DoctorDTO;
import com.clinic.hms.doctor.entity.Doctor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class DoctorMapperImplTest {

    private DoctorMapperImpl doctorMapper;

    @BeforeEach
    void setUp() {
        doctorMapper = new DoctorMapperImpl();
    }


    @Test
    void canMapDoctorDtoToDoctorEntity() {
        //given
        DoctorDTO doctorDTO = DoctorDTO.builder()
                .name("Akhil")
                .dateOfBirth("18-06-1990")
                .qualification("MBBS")
                .department("Cardiology")
                .designation("Cardiologist")
                .consultationFee("500")
                .build();
        //when
        Doctor doctorEntity = doctorMapper.toDoctorEntity(doctorDTO);
        //then
        assertThat(doctorEntity)
                .hasFieldOrPropertyWithValue("name", "Akhil")
                .hasFieldOrPropertyWithValue("dateOfBirth", "18-06-1990")
                .hasFieldOrPropertyWithValue("qualification", "MBBS")
                .hasFieldOrPropertyWithValue("designation", "Cardiologist")
                .hasFieldOrPropertyWithValue("department", "Cardiology")
                .hasFieldOrPropertyWithValue("consultationFee", "500");

    }

    @Test
    void canMapDoctorEntityListToDoctorDTOList() {
        //given
        Doctor doctor1 = Doctor.builder()
                .name("Akhil")
                .dateOfBirth("18-06-1990")
                .qualification("MBBS")
                .department("Cardiology")
                .designation("Cardiologist")
                .consultationFee("500")
                .build();
        List<Doctor> doctorEntityList = new ArrayList<>();
        doctorEntityList.add(doctor1);

        //when
        List<DoctorDTO> doctorDTOList = doctorMapper.toDoctorDTOList(doctorEntityList);

        //then
        assertThat(doctorDTOList.size()).isEqualTo(doctorEntityList.size());
    }

    @Test
    void canMapDoctorEntityToDoctorDTO() {
        //given
        Doctor doctor = Doctor.builder()
                .name("Akhil")
                .dateOfBirth("18-06-1990")
                .qualification("MBBS")
                .department("Cardiology")
                .designation("Cardiologist")
                .consultationFee("500")
                .build();

        //when
        DoctorDTO doctorDTO = doctorMapper.toDoctorDTO(doctor);

        //then
        // comparing each and every field explicitly
        assertThat(doctorDTO)
                .hasFieldOrPropertyWithValue("name", "Akhil")
                .hasFieldOrPropertyWithValue("dateOfBirth", "18-06-1990")
                .hasFieldOrPropertyWithValue("qualification", "MBBS")
                .hasFieldOrPropertyWithValue("designation", "Cardiologist")
                .hasFieldOrPropertyWithValue("department", "Cardiology")
                .hasFieldOrPropertyWithValue("consultationFee", "500");

        // automated comparison of all fields
        assertThat(doctorDTO)
                .usingRecursiveComparison()
                .isEqualTo(doctor);
    }

    @Test
    void cannotMapDoctorDTOToDoctorEntity() {
        //given
        DoctorDTO doctorDTO = DoctorDTO.builder()
                .name(null)
                .dateOfBirth(null)
                .qualification(null)
                .department(null)
                .designation(null)
                .consultationFee(null)
                .build();
        //when
        //then
        assertThatThrownBy(() -> doctorMapper.toDoctorEntity(doctorDTO))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("Doctor DTO objects are null");
    }

    @Test
    void isNotValidDoctorDTO() {
        //given
        DoctorDTO doctorDTO = DoctorDTO.builder()
                .name(null)
                .dateOfBirth(null)
                .qualification(null)
                .department(null)
                .designation(null)
                .consultationFee(null)
                .build();
        //when
        Boolean isNotAValidDoctor = doctorMapper.isNotValidDoctorDTO(doctorDTO);
        //then
        assertThat(isNotAValidDoctor).isEqualTo(true);
    }
}