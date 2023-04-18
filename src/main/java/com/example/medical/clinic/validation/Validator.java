package com.example.medical.clinic.validation;

import com.example.medical.clinic.domain.dto.UserDto;

public interface Validator {
    void validate(UserDto userDto);
}
