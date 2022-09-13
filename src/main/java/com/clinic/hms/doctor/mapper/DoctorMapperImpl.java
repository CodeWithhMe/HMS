package com.clinic.hms.doctor.mapper;

import com.clinic.hms.doctor.dto.DoctorDTO;
import com.clinic.hms.doctor.entity.Doctor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

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
        return Doctor.builder()
                .name(doctorDTO.getName())
                .dateOfBirth(doctorDTO.getDateOfBirth())
                .department(doctorDTO.getDepartment())
                .designation(doctorDTO.getDesignation())
                .qualification(doctorDTO.getQualification())
                .consultationFee(doctorDTO.getConsultationFee())
                .build();
    }

    /**
     * Maps a list of Doctor Entities to
     * List of Doctor DTOs
     *
     * @param doctorList List of doctor entities
     *                   and this could be null
     * @return Checks if list is empty, otherwise
     * Returns a List of DoctorDTOs
     */
    @Override
    public List<DoctorDTO> toDoctorDTOList(List<Doctor> doctorList) {
        return Stream.ofNullable(doctorList)
                .flatMap(Collection::stream)
                .map(this::toDoctorDTO)
                .toList();
    }

    /**
     * Map Doctor Entity to Doctor DTO
     *
     * @param doctor Doctor Entity
     * @return Returns a Doctor DTO
     */
    @Override
    public DoctorDTO toDoctorDTO(Doctor doctor) {
        return DoctorDTO.builder()
                .name(doctor.getName())
                .dateOfBirth(doctor.getDateOfBirth())
                .qualification(doctor.getQualification())
                .designation(doctor.getDesignation())
                .department(doctor.getDepartment())
                .consultationFee(doctor.getConsultationFee())
                .build();
    }
}
