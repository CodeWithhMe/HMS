package com.clinic.hms.patient.model;

import lombok.Data;
import java.io.File;

@Data
public class Patient {
    private String patientName;
    private String patientAge;
    private File patientFile;
}
