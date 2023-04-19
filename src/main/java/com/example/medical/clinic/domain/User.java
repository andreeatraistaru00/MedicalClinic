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
    @JoinColumn(referencedColumnName = "id",name = "role_id")
    @OneToOne(targetEntity = Role.class)
    private Role role;

    @Getter
    @JoinColumn(referencedColumnName = "id",name = "speciality_id")
    @OneToOne(targetEntity = Speciality.class)
    private Speciality speciality;


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
    @Column(name = "last_modified_date")
    private Date lastUpdate;

    public String getFullName() {
        return lastName + " " + firstName;
    }


    public User(String username, String email, String password, String firstName, String lastName, Role role,  Date createdDate, Date lastUpdate) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.speciality = speciality;
        this.createdDate = createdDate;
        this.lastUpdate = lastUpdate;
    }
}
