package com.clinic.hms.doctor.service;

import com.clinic.hms.doctor.entity.Doctor;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    public Doctor saveOrUpdate(Doctor doctor) {
        return new Doctor(doctor.getName(),
                doctor.getQualification(),
                doctor.getDesignation(),
                doctor.getDepartment(),
                doctor.getConsultationFee()
        );
    }
}
