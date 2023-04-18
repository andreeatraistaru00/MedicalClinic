package com.example.medical.clinic.exception;


import lombok.Getter;

@Getter
public class MedicalClinicException extends RuntimeException{

    private Integer code;

    private String message;

    public MedicalClinicException(String message, Integer code) {
        super(message);
        this.code = code;
    }
}
