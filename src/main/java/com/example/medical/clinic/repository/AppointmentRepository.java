package com.example.medical.clinic.repository;

import com.example.medical.clinic.domain.Appointment;
import com.example.medical.clinic.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAppointmentsByMedic(User medic);

    List<Appointment> findAppointmentsByPacient(User pacient);
    Appointment findAppointmentByIdAndPacient(Long id,User pacient);
}
