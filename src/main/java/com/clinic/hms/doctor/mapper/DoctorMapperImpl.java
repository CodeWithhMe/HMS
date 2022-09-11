package com.clinic.hms.doctor.mapper;

import com.clinic.hms.doctor.dto.DoctorDTO;
import com.clinic.hms.doctor.entity.Doctor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author akhilkanakendran
 * Implementation class for DoctorMapper
 * for Doctor Entity
 */
@Component
public class DoctorMapperImpl implements DoctorMapper {

    /**
     * Map DoctorDTO to Doctor Entity
     *
     * @param doctorDTO DTO for Doctor
     * @return Doctor Entity
     */
    @Override
    public Doctor toDoctorEntity(DoctorDTO doctorDTO) {

        if (doctorDTO == null) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setName(doctorDTO.getName());
        doctor.setDepartment(doctorDTO.getDepartment());
        doctor.setDesignation(doctorDTO.getDesignation());
        doctor.setQualification(doctorDTO.getQualification());
        doctor.setConsultationFee(doctorDTO.getConsultationFee());

        return doctor;
    }

    /**
     * Maps a list of Doctor Entities to
     * List of Doctor DTOs
     *
     * @param doctorList List of doctor entities
     * @return Returns a List of DoctorDTOs
     */
    @Override
    public List<DoctorDTO> toDoctorDTOList(List<Doctor> doctorList) {
        if (doctorList == null) {
            return null;
        }

        List<DoctorDTO> doctorDTOList = new ArrayList<>(doctorList.size());
        for (Doctor doctor : doctorList) {
            doctorDTOList.add(toDoctorEntity(doctor));
        }
        return doctorDTOList;
    }

    /**
     * Map Doctor Entity to Doctor DTO
     *
     * @param doctor Doctor Entity
     * @return Returns a Doctor DTO
     */
    @Override
    public DoctorDTO toDoctorEntity(Doctor doctor) {
        return DoctorDTO.builder()
                .name(doctor.getName())
                .qualification(doctor.getQualification())
                .designation(doctor.getDesignation())
                .department(doctor.getDepartment())
                .consultationFee(doctor.getConsultationFee())
                .build();
    }
}
