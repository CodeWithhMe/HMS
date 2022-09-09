package com.clinic.hms.doctor.mapper;

import com.clinic.hms.doctor.dto.DoctorDTO;
import com.clinic.hms.doctor.entity.Doctor;
import org.springframework.stereotype.Component;

@Component
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public Doctor doctorDTOToDoctor(DoctorDTO doctorDTO) {

        if (doctorDTO == null) {
            return null;
        }
        Doctor doctor = new Doctor();

        doctor.setId(doctorDTO.getId());
        doctor.setName(doctorDTO.getName());
        doctor.setDepartment(doctorDTO.getDepartment());
        doctor.setDesignation(doctorDTO.getDesignation());
        doctor.setQualification(doctorDTO.getQualification());
        doctor.setConsultationFee(doctorDTO.getConsultationFee());

        return doctor;
    }

}
