package com.example.medical.clinic.security.jwt;

import com.example.medical.clinic.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class JwtSubject {

    private String username;

    private Role role;

    @Override
    public String toString() {
        return "username: "+this.getUsername() + " " + " role: "+ role.getDescription();
    }
}
