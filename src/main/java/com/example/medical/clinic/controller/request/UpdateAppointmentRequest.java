package com.example.medical.clinic.controller.request;

import com.example.medical.clinic.domain.enums.AppointmentStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Getter
@AllArgsConstructor
@Immutable
public class UpdateAppointmentRequest {
    private Long appointmentId;
    private AppointmentStatusEnum status;
}
