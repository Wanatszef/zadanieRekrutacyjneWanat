package com.xcodesoftware.zadanieRekrutacyjneWanat.repository;

import com.xcodesoftware.zadanieRekrutacyjneWanat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByFirstNameAndLastName(String firstName, String lastName);
}
