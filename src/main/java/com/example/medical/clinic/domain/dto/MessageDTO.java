package com.example.medical.clinic.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Getter
@AllArgsConstructor
@Immutable
public class MessageDTO {
    private final String message;

    public static MessageDTO of(final String message) {
        return new MessageDTO(message);
    }
}
