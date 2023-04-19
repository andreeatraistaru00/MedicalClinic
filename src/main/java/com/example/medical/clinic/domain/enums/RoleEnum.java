package com.example.medical.clinic.domain.enums;

public enum RoleEnum {

    MEDIC("ROLE_MEDIC"),
    PACIENT("ROLE_PACIENT");

    private final String description;

    RoleEnum(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
