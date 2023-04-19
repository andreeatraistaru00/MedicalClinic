package com.example.medical.clinic.aop;

import com.example.medical.clinic.exception.MedicalClinicException;
import com.example.medical.clinic.validation.ValidationResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHanlder extends ResponseEntityExceptionHandler {

        @ExceptionHandler(value
                = { MedicalClinicException.class})
        protected ResponseEntity<Object> handleConflict(
                MedicalClinicException ex, WebRequest request) {
            var bodyOfResponse = new ValidationResponse(ex.getMessage());
            return ResponseEntity.status(ex.getCode()).body(bodyOfResponse);
        }

}
