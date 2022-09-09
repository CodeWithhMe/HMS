package com.clinic.hms.doctor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DoctorDTO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("qualification")
    private String qualification;
    @JsonProperty("designation")
    private String designation;
    @JsonProperty("department")
    private String department;
    @JsonProperty("consultationFee")
    private String consultationFee;

    public DoctorDTO(String name, String qualification, String designation, String department, String consultationFee) {
        this.name = name;
        this.qualification = qualification;
        this.designation = designation;
        this.department = department;
        this.consultationFee = consultationFee;
    }
}
