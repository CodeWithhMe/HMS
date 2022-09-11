package com.clinic.hms.doctor.mapper;

import com.clinic.hms.doctor.dto.DoctorDTO;
import com.clinic.hms.doctor.entity.Doctor;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author akhilkanakendran
 * DoctorMapper Interface
 */
@Mapper
public interface DoctorMapper {

    /**
     * Map Doctor DTO to Doctor Entity
     *
     * @param doctorDTO DTO class of Doctor
     * @return Doctor entity class
     */
    Doctor toDoctorEntity(DoctorDTO doctorDTO);

    /**
     * Map List of Doctor Entities to DoctorDTO's
     *
     * @param doctors List of doctor entities
     * @return List of Doctor DTO's
     */
    List<DoctorDTO> toDoctorDTOList(List<Doctor> doctors);

    /**
     * Map Doctor Entity to Doctor DTO
     *
     * @param doctor Doctor Entity
     * @return Returns a Doctor DTO
     */
    DoctorDTO toDoctorDTO(Doctor doctor);
}
