package com.example.medical.clinic.service;

import com.example.medical.clinic.controller.request.SignupRequest;
import com.example.medical.clinic.domain.User;
import com.example.medical.clinic.domain.dto.UserDto;

public interface UserService {

    User saveUser(SignupRequest userDto);

    Long getAuthenticatedUserId();

}
