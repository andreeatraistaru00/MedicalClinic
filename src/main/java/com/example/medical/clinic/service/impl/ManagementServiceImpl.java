package com.example.medical.clinic.service.impl;

import com.example.medical.clinic.controller.request.CreateAppointmentRequest;
import com.example.medical.clinic.controller.request.UpdateAppointmentRequest;
import com.example.medical.clinic.domain.*;
import com.example.medical.clinic.domain.dto.AppointmentDTO;
import com.example.medical.clinic.domain.dto.MessageDTO;
import com.example.medical.clinic.domain.enums.AppointmentStatusEnum;
import com.example.medical.clinic.domain.enums.RoleEnum;
import com.example.medical.clinic.repository.*;
import com.example.medical.clinic.service.ManagementService;
import com.example.medical.clinic.utils.Formatters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ManagementServiceImpl implements ManagementService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AppointmentStatusRepository appointmentStatusRepository;
    private final ClinicRepository clinicRepository;
    private final AppointmentRepository appointmentRepository;

    public AppointmentDTO createAppointment(final CreateAppointmentRequest createAppointmentRequest) {
        final Role medicRole = find(RoleEnum.MEDIC);
        final Role pacientRole = find(RoleEnum.PACIENT);
        final User medic = find(createAppointmentRequest.getMedicId(), medicRole);
        final User pacient = find(createAppointmentRequest.getPacientId(), pacientRole);
        final AppointmentStatus status = find(AppointmentStatusEnum.PENDING);
        final Clinic clinic = find(createAppointmentRequest.getClinicId());
        Appointment appointment = new Appointment();
        appointment.setMedic(medic);
        appointment.setPacient(pacient);
        appointment.setClinic(clinic);
        appointment.setSummary(createAppointmentRequest.getSummary());
        appointment.setAppointmentStatus(status);
        appointment.setDate(LocalDate.parse(createAppointmentRequest.getDate(), Formatters.DATE_FORMATTER));
        appointment.setTime(LocalTime.parse(createAppointmentRequest.getTime(), Formatters.TIME_FORMATTER));
        return AppointmentDTO.of(appointmentRepository.save(appointment));
    }

    @Override
    public AppointmentDTO updateAppointment(final UpdateAppointmentRequest updateAppointmentRequest) {
       Appointment appointment = findAppointment(updateAppointmentRequest.getAppointmentId());
       AppointmentStatus status = find(updateAppointmentRequest.getStatus());
       appointment.setAppointmentStatus(status);
       return AppointmentDTO.of(appointmentRepository.save(appointment));
    }

    @Override
    public MessageDTO deleteAppointment(final Long id) {
        appointmentRepository.deleteById(id);
        return MessageDTO.of("Appointment with id " + id + " has been deleted");
    }

    @Override
    public List<AppointmentDTO> getUserAppointments(final Long userId) {
        User user = userRepository.findById(userId).orElseThrow( () -> new RuntimeException("User not found"));
        if(RoleEnum.MEDIC.getDescription().equals(user.getRole().getDescription())) {
            return appointmentRepository.findAppointmentsByMedic(user)
                    .stream()
                    .map(AppointmentDTO::of)
                    .collect(Collectors.toList());
        }
        return appointmentRepository.findAppointmentsByPacient(user)
                .stream()
                .map(AppointmentDTO::of)
                .collect(Collectors.toList());
    }

    private Appointment findAppointment(final Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment could not be found"));
    }

    private Clinic find(final Long id) {
        return clinicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Missing clinic."));
    }

    private AppointmentStatus find(final AppointmentStatusEnum status) {
        return appointmentStatusRepository
                .findByDescription(status.getDescription())
                .orElseThrow(() -> new RuntimeException("Could not find pacient."));
    }

    private User find(final Long id, final Role role) {
        return userRepository
                .findByIdAndRole(id, role)
                .orElseThrow(() -> new RuntimeException("Could not find" + role.getDescription() + "."));
    }

    private Role find(final RoleEnum role) {
        return roleRepository
                .findByDescription(role.getDescription())
                .orElseThrow(() -> new RuntimeException("Could not find" + role.getDescription() + "role."));
    }


}
