package com.example.medical.clinic.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Clinic")
public class Clinic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Column(name = "id")
    private Long id;

    @Setter
    @Getter
    @Column(name = "description")
    private String description;


    @OneToMany(mappedBy = "clinic")
    private Set<Medic> medics;



}
