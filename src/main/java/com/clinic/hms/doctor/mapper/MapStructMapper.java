package com.clinic.hms.doctor.mapper;

import com.clinic.hms.doctor.dto.DoctorDTO;
import com.clinic.hms.doctor.entity.Doctor;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {
    Doctor doctorDTOToDoctor(DoctorDTO doctorDTO);
}
