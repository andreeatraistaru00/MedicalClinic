package com.example.medical.clinic.domain.enums;

public enum AppointmentType {
    CONSULTATION("CONSULTATION"),
    INTERVENTION("INTERVENTION"),
    EMERGENCY("EMERGENCY");



    private final  String type;

    AppointmentType(String type) {
        this.type = type;
    }

    public String getValue() {
        return type;
    }
}
