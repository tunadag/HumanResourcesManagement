package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRepository extends JpaRepository<Personal, Long> {

    Optional<Personal> findOptionalByEmail(String email);
    Optional<Personal> findOptionalByEmailAndPassword(String email, String password);
}
