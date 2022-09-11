package com.clinic.hms.doctor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author akhilkanakendran
 * DTO Class for Doctor Entity
 */
@Getter
@AllArgsConstructor
@Builder
public class DoctorDTO {
    private String name;
    private String qualification;
    private String designation;
    private String department;
    private String consultationFee;

}
