package com.example.medical.clinic.controller;


import com.example.medical.clinic.controller.request.CreateAppointmentRequest;
import com.example.medical.clinic.controller.request.UpdateAppointmentRequest;
import com.example.medical.clinic.domain.dto.AppointmentDTO;
import com.example.medical.clinic.domain.dto.MessageDTO;
import com.example.medical.clinic.service.ManagementService;
import com.example.medical.clinic.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/management/")
@SecurityRequirement(name = "api")
public class ManagementController {

    private final ManagementService managementService;
    private final UserService userService;

    @PostMapping(path = "/create-appointment")
    @PreAuthorize("hasRole('ROLE_PACIENT')")
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody final CreateAppointmentRequest createAppointmentRequest){
        AppointmentDTO response = managementService.createAppointment(createAppointmentRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping(path = "/update-appointment")
    @PreAuthorize("hasRole('ROLE_MEDIC')")
    public ResponseEntity<AppointmentDTO> updateAppointment(@RequestBody final UpdateAppointmentRequest updateAppointmentRequest){
        AppointmentDTO response = managementService.updateAppointment(updateAppointmentRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/delete-appointment/{id}")
    @PreAuthorize("hasRole('ROLE_PACIENT')")
    public ResponseEntity<MessageDTO> deleteAppointment(@PathVariable final Long id){
        var pacientId = userService.getAuthenticatedUserId();
        MessageDTO response = managementService.deleteAppointment(id,pacientId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/get-appointments")
    @PreAuthorize("hasRole('ROLE_PACIENT') or hasRole('ROLE_MEDIC')")
    public ResponseEntity<List<AppointmentDTO>> getUserAppointments(){
        var userId = userService.getAuthenticatedUserId();
        List<AppointmentDTO> response = managementService.getUserAppointments(userId);
        return ResponseEntity.ok(response);
    }

}
