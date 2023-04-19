package com.example.medical.clinic.domain.dto;

import com.example.medical.clinic.domain.Clinic;
import com.example.medical.clinic.domain.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
public class UserDto {

    private final String username;

    private final String email;

    private final String password;

    private final String firstName;

    private final String lastName;

    private final Role role;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private final Date createdDate;


}
