package com.example.medical.clinic.validation;

import com.example.medical.clinic.domain.dto.UserDto;
import com.example.medical.clinic.domain.enums.ERoles;
import com.example.medical.clinic.exception.MedicalClinicException;
import com.example.medical.clinic.exception.UserValidationError;
import com.example.medical.clinic.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import java.util.Objects;


@Component
@RequiredArgsConstructor
public class PatientValidator implements Validator {

    private final Utils utils;
    @Override
    public void validate(UserDto userDto) {
        if(Objects.isNull(userDto.getEmail()) || Strings.isEmpty(userDto.getEmail())){
            throw new MedicalClinicException(UserValidationError.EMPTY_EMAIL.getMessage()
                    ,UserValidationError.EMPTY_EMAIL.getCode());
        }
        if(Objects.isNull(userDto.getPassword()) || Strings.isEmpty(userDto.getPassword())){
            throw new MedicalClinicException(UserValidationError.EMPTY_PASSWORD.getMessage()
                    ,UserValidationError.EMPTY_PASSWORD.getCode());
        }
        if(Objects.isNull(userDto.getFirstName()) || Strings.isEmpty(userDto.getFirstName())){
            throw new MedicalClinicException(UserValidationError.EMPTY_FIRST_NAME.getMessage()
                    ,UserValidationError.EMPTY_FIRST_NAME.getCode());
        }
        if(Objects.isNull(userDto.getFirstName()) || Strings.isEmpty(userDto.getFirstName())){
            throw new MedicalClinicException(UserValidationError.EMPTY_LAST_NAME.getMessage()
                    ,UserValidationError.EMPTY_LAST_NAME.getCode());
        }
        if(Objects.isNull(userDto.getUsername()) || Strings.isEmpty(userDto.getUsername())){
            throw new MedicalClinicException(UserValidationError.EMPTY_USERNAME.getMessage()
                    ,UserValidationError.EMPTY_USERNAME.getCode());
        }
        if(!EmailValidator.getInstance().isValid(userDto.getEmail())){
            throw new MedicalClinicException(UserValidationError.WRONG_FORMAT_EMAIL.getMessage()
                    ,UserValidationError.WRONG_FORMAT_EMAIL.getCode());
        }
        if(!utils.isValidPassword(userDto.getPassword())){
            throw new MedicalClinicException(UserValidationError.WRONG_FORMAT_EMAIL.getMessage()
                    ,UserValidationError.WRONG_FORMAT_PASSWORD.getCode());
        }
    }


}
