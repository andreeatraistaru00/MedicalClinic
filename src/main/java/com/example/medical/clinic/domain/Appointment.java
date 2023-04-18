package com.example.medical.clinic.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "appointment")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Appointment implements Serializable {

    @Getter
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id", nullable = false)
    private User user;

    @Getter
    @Setter
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id", nullable = false)
    private User medic;


    @Getter
    @Column(name = "date")
    @NotBlank
    private LocalDate date;

    @Getter
    @Column(name = "hour")
    @NotBlank
    private LocalTime hour;

    @Getter
    @Column(name = "type")
    @Size(max = 50)
    private String type;

    @Getter
    @ManyToOne
    @JsonBackReference
    @JoinColumn(referencedColumnName = "id",name = "speciality_id")
    private Speciality specialty;


    @Getter
    @ManyToOne
    @JsonBackReference
    @JoinColumn(referencedColumnName = "id",name = "clinic_id")
    private Clinic clinic;

    @Getter
    @Setter
    @Column(name = "summary")
    @NotBlank
    @Size(max = 150)
    private String summary;


    @Getter
    @Setter
    @OneToOne(targetEntity = AppointmentStatus.class)
    @JoinColumn(referencedColumnName = "id",name = "status_id")
    private AppointmentStatus appointmentStatus;



}
