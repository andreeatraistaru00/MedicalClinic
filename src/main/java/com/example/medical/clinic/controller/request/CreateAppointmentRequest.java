package com.example.medical.clinic.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Getter
@AllArgsConstructor
@Immutable
public class CreateAppointmentRequest {

    private Long pacientId;
    private Long medicId;
    private Long clinicId;
    private String summary;
    private String date;
    private String time;
}
