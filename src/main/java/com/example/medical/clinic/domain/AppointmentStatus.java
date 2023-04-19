package com.example.medical.clinic.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="appointment_status")
public class AppointmentStatus implements Serializable {


    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Getter
    @Setter
    @NotBlank
    @Size(max=10)
    @Column(name = "description")
    private String description;

}
