package com.clinic.hms.doctor.mapper;

import com.clinic.hms.doctor.dto.DoctorDTO;
import com.clinic.hms.doctor.entity.Doctor;
import org.mapstruct.Mapper;

/**
 * @author akhilkanakendran
 * MapStructMapper Interface
 */
@Mapper(componentModel = "spring")
public interface MapStructMapper {

    /**
     * Map Doctor DTO to Doctor Entity
     *
     * @param doctorDTO DTO class of Doctor
     * @return Doctor entity class
     */
    Doctor toDoctor(DoctorDTO doctorDTO);
}
