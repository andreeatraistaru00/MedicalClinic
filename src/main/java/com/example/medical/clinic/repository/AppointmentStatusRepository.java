package com.example.medical.clinic.repository;

import com.example.medical.clinic.domain.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface AppointmentStatusRepository extends JpaRepository<AppointmentStatus, Long> {

    Optional<AppointmentStatus> findByDescription(String description);
}
