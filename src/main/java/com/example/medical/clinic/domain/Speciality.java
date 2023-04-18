package com.example.medical.clinic.domain;

import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "speciality")
public class Speciality implements Serializable {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "description")
    private String description;
}
