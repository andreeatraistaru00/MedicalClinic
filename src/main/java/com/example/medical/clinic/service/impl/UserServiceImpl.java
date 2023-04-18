package com.example.medical.clinic.service.impl;

import com.example.medical.clinic.domain.User;
import com.example.medical.clinic.domain.dto.UserDto;
import com.example.medical.clinic.repository.UserRepository;
import com.example.medical.clinic.service.UserService;
import com.example.medical.clinic.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final Validator userValidator;
    private final ModelMapper modelMapper;

    @Override
    public User saveUser(UserDto userDto) {
        userValidator.validate(userDto);
        User user = modelMapper.map(userDto,User.class);
        return userRepository.saveUser(user);
    }
}
