package com.example.medical.clinic.domain.enums;

public enum AppointmentStatusEnum {
    APPROVED("approved",1),
    PENDING("pending",2),
    REJECTED("rejected",3),
    CANCELED("canceled",4);

    AppointmentStatusEnum(String description, Integer id) {
        this.description = description;
        this.id = id;
    }

    private String description;
    private Integer id;


    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
