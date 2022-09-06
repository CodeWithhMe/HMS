package com.clinic.hms.doctor.controller;

import com.clinic.hms.doctor.entity.Doctor;
import com.clinic.hms.doctor.repository.DoctorRepository;
import com.clinic.hms.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DoctorRegistrationController implements ErrorController {

    private final DoctorService doctorService;
    @Autowired
    DoctorRepository doctorRepository;

    public DoctorRegistrationController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllTutorials(@RequestParam(required = false) String name) {
        try {
            List<Doctor> doctors = new ArrayList<>();
            /*Optional.ofNullable(name)
                    .map(doctorList -> doctors.addAll(doctorRepository.findByNameContaining(name)))
                    .orElse(doctors.addAll(doctorRepository.findAll()));*/
            if (name == null)
                doctors.addAll(doctorRepository.findAll());
            else
                doctors.addAll(doctorRepository.findByNameContaining(name));
            if (doctors.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(doctors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/doctors")
    public ResponseEntity<Doctor> addNewDoctor(@RequestBody Doctor doctor) {
        Doctor _doctor = doctorRepository.save(doctorService.saveOrUpdate(doctor));
        return new ResponseEntity<>(_doctor, HttpStatus.CREATED);
    }
}
