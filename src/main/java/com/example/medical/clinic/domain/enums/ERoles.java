package com.example.medical.clinic.domain.enums;

public enum ERoles {
    PACIENT("PACIENT"),
    MEDIC("MEDIC"),
    ADMIN("ADMIN");

    private final  String type;

    ERoles(String type) {
        this.type = type;
    }

    public String getValue() {
        return type;
    }


}
