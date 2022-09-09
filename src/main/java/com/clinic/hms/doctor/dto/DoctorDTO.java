package com.clinic.hms.doctor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public class DoctorDTO {
    private String name;
    private String qualification;
    private String designation;
    private String department;
    private String consultationFee;

}
