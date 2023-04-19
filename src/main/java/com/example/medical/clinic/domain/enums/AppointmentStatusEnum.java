package com.example.medical.clinic.domain.enums;

import lombok.Getter;

@Getter
public enum AppointmentStatusEnum {
    APPROVED("APPROVED"),
    PENDING("PENDING"),
    REJECTED("REJECTED");

    private String description;


    AppointmentStatusEnum(String description) {
        this.description = description;
    }
}
