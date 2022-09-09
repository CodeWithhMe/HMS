package com.clinic.hms.doctor.controller;

import com.clinic.hms.doctor.dto.DoctorDTO;
import com.clinic.hms.doctor.entity.Doctor;
import com.clinic.hms.doctor.mapper.MapStructMapper;
import com.clinic.hms.doctor.repository.DoctorRepository;
import com.clinic.hms.doctor.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class DoctorRegistrationController implements ErrorController {

    private final DoctorService doctorService;
    private final DoctorRepository doctorRepository;
    private final MapStructMapper mapstructMapper;

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllTutorials(@RequestParam(required = false) String name) {
        try {
            List<Doctor> doctors = new ArrayList<>();
            if (name == null)
                doctors.addAll(doctorRepository.findAll());
            else
                doctors.addAll(doctorRepository.findDoctorsByName(name));
            if (doctors.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(doctors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/doctors")
    public ResponseEntity<DoctorDTO> addNewDoctor(@RequestBody DoctorDTO doctorDTO) {
        // use mapstruct to map DTO to entity
        doctorService.save(mapstructMapper.toDoctor(doctorDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorDTO);
    }
}
