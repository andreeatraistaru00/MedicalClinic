package com.example.medical.clinic.service;

import com.example.medical.clinic.controller.request.CreateAppointmentRequest;
import com.example.medical.clinic.controller.request.UpdateAppointmentRequest;
import com.example.medical.clinic.domain.dto.AppointmentDTO;
import com.example.medical.clinic.domain.dto.MessageDTO;

import java.util.List;

public interface ManagementService {

    AppointmentDTO createAppointment(final CreateAppointmentRequest createAppointmentRequest, Long pacientId);

    AppointmentDTO updateAppointment(UpdateAppointmentRequest updateAppointmentRequest, Long userId);

    MessageDTO deleteAppointment(Long id, Long userId);

    List<AppointmentDTO> getUserAppointments(Long userId);
}
