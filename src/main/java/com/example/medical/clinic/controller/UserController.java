package com.example.medical.clinic.controller;


import com.example.medical.clinic.domain.dto.UserDto;
import com.example.medical.clinic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/")
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/registerPatient")
    public ResponseEntity createUser(@RequestBody final UserDto patient){
        var response = userService.saveUser(patient);
        return ResponseEntity.ok(response);

    }


}
