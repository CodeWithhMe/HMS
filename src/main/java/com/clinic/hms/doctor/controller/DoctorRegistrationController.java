package com.clinic.hms.doctor.controller;

import com.clinic.hms.doctor.dto.DoctorDTO;
import com.clinic.hms.doctor.mapper.DoctorMapper;
import com.clinic.hms.doctor.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author akhilkanakendran
 * Controller Class exposing the API's
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class DoctorRegistrationController implements ErrorController {

    private final DoctorService doctorService;
    private final DoctorMapper doctorMapper;

    /**
     * Get operation to list all doctors
     * matching the name passed as argument
     *
     * @return ResponseEntity<List < Doctor>>
     * List of Doctor entities
     */
    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorDTO>> findAllDoctors() {
        return ResponseEntity.ok(doctorMapper.toDoctorDTOList(doctorService.findAll()));
    }

    /**
     * Add new doctor to the table
     *
     * @param doctorDTO Doctor Details from the request
     * @return Status of the request along with the DoctorDTO response
     */
    @PostMapping("/doctors")
    public ResponseEntity<DoctorDTO> addNewDoctor(@RequestBody DoctorDTO doctorDTO) {
        // use mapstruct to map DTO to entity
        doctorService.save(doctorMapper.toDoctorEntity(doctorDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorDTO);
    }
}
