package com.example.medical.clinic.security.jwt;

import com.example.medical.clinic.domain.Role;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.gson.GsonBuilderCustomizer;


@Getter
@Setter
@AllArgsConstructor
public class JwtSubject {

    private String username;

    private Role role;

    @Override
    public String toString() {
        var json = new Gson();
        return json.toJson(this);
    }
}
