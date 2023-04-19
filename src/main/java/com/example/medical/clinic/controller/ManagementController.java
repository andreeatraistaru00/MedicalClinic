package com.example.medical.clinic.controller;


import com.example.medical.clinic.controller.request.CreateAppointmentRequest;
import com.example.medical.clinic.controller.request.UpdateAppointmentRequest;
import com.example.medical.clinic.domain.dto.AppointmentDTO;
import com.example.medical.clinic.domain.dto.MessageDTO;
import com.example.medical.clinic.service.ManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/management/")
public class ManagementController {

    private final ManagementService managementService;

    @PostMapping(path = "/create-appointment")
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody final CreateAppointmentRequest createAppointmentRequest){
        AppointmentDTO response = managementService.createAppointment(createAppointmentRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping(path = "/update-appointment")
    public ResponseEntity<AppointmentDTO> updateAppointment(@RequestBody final UpdateAppointmentRequest updateAppointmentRequest){
        AppointmentDTO response = managementService.updateAppointment(updateAppointmentRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/delete-appointment/{id}")
    public ResponseEntity<MessageDTO> deleteAppointment(@PathVariable final Long id){
        MessageDTO response = managementService.deleteAppointment(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/get-appointments/{userId}")
    public ResponseEntity<List<AppointmentDTO>> getUserAppointments(@PathVariable final Long userId){
        List<AppointmentDTO> response = managementService.getUserAppointments(userId);
        return ResponseEntity.ok(response);
    }

}
