package com.example.medical.clinic.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Getter
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(name = "user_name")
    private String username;

    @Getter
    @Column(name = "email")
    private String email;

    @Getter
    @Column(name = "password")
    private String password;

    @Getter
    @Column(name = "first_name")
    private String firstName;

    @Getter
    @Column(name = "last_name")
    private String lastName;

    @Getter
    @Column(name = "role_id")
    @JoinColumn(name = "id")
    @OneToOne(targetEntity = Role.class)
    private Role role;


    @Setter
    @Getter
    @Column(name = "clinic_id")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "medic_clinic",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "clinic_id"))
    private Set<Clinic> clinics = new HashSet<>();

    @Getter
    @Column(name = "created_date")
    private Date createdDate;

    @Getter
    @Column(name = "last_updated_date")
    private Date lastUpdate;


}
