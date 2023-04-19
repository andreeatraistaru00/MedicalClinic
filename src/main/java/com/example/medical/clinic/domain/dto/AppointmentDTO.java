package com.example.medical.clinic.domain.dto;

import com.example.medical.clinic.domain.Appointment;
import com.example.medical.clinic.utils.Formatters;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Getter
@AllArgsConstructor
@Immutable
public class AppointmentDTO {

    private Long id;

    private String pacient;

    private String medic;

    private String date;

    private String time;

    private String clinic;

    private String summary;

    private String appointmentStatus;
    public static AppointmentDTO of(final Appointment appointment) {
        return new AppointmentDTO(
                appointment.getId(),
                appointment.getPacient().getFullName(),
                appointment.getMedic().getFullName(),
                appointment.getDate().format(Formatters.DATE_FORMATTER),
                appointment.getTime().format(Formatters.TIME_FORMATTER),
                appointment.getClinic().getDescription(),
                appointment.getSummary(),
                appointment.getAppointmentStatus().getDescription());
    }

}
