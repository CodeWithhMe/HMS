package com.clinic.hms.doctor.mapper;

import com.clinic.hms.doctor.dto.DoctorDTO;
import com.clinic.hms.doctor.entity.Doctor;
import org.springframework.stereotype.Component;

/**
 * @author akhilkanakendran
 * Implementation class for MapStructMapper
 */
@Component
public class MapStructMapperImpl implements MapStructMapper {

    /**
     * Map DoctorDTP to Doctor Entity
     *
     * @param doctorDTO DTO for Doctor
     * @return Doctor Entity
     */
    @Override
    public Doctor toDoctor(DoctorDTO doctorDTO) {

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

}
