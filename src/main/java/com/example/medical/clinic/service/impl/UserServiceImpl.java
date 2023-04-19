package com.example.medical.clinic.service.impl;

import com.example.medical.clinic.domain.User;
import com.example.medical.clinic.domain.dto.UserDto;
import com.example.medical.clinic.domain.enums.RoleEnum;
import com.example.medical.clinic.repository.RoleRepository;
import com.example.medical.clinic.repository.UserRepository;
import com.example.medical.clinic.service.UserService;
import com.example.medical.clinic.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final Validator userValidator;

    private final RoleRepository roleRepository;

    private final PasswordEncoder encoder;

    @Override
    public User saveUser(UserDto userDto) {
        userValidator.validate(userDto);
        var password = encoder.encode(userDto.getPassword());
        var pacientRole = roleRepository.findOneByDescription(RoleEnum.PACIENT.getDescription());
        var user = new User(userDto.getUsername(),userDto.getEmail(),
                password,userDto.getFirstName(), userDto.getLastName(),pacientRole,new Date(),new Date());
        return userRepository.save(user);
    }

}
