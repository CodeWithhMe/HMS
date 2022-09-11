package com.clinic.hms.doctor.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * @author akhilkanakendran
 * DTO Class for Doctor Entity
 */
@Getter
@Builder
public class DoctorDTO {
    private String name;
    private String qualification;
    private String designation;
    private String department;
    private String consultationFee;

}
