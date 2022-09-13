package com.clinic.hms.doctor.repository;

import com.clinic.hms.doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author akhilkanakendran
 * Interface for Data JPA
 */
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    /**
     * Find doctors matching the name
     *
     * @param name Name of the doctor
     * @return List of doctor matching the name
     */
    List<Doctor> findDoctorsByName(String name);

    /**
     * Returns TRUE if doctor with same name
     * and DOB exists, otherwise returns FALSE
     *
     * @param name        Name of the doctor
     * @param dateOfBirth DOB of the doctor
     * @return Returns True or False
     */
    @Query("SELECT CASE WHEN COUNT(d) > 0 " +
            " THEN true ELSE false END " +
            "from Doctor d " +
            "where d.name = ?1 " +
            "And d.dateOfBirth = ?2 "
    )
    Boolean selectDoctorNameAndDOBExists(String name, String dateOfBirth);

}