package com.example.medical.clinic.domain;

import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="roles")
public class Role implements Serializable {

    @Getter
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Column(name = "description",length = 20)
    private String description;

}
