package com.example.medical.clinic.repository;

import com.example.medical.clinic.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByDescription(String description);
    Role findOneByDescription(String description);
}
