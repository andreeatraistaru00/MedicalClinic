package com.example.medical.clinic.repository;

import com.example.medical.clinic.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User saveUser(User user);
    Optional<User> findByUsername(String username);
}
