package com.example.remember_app.Repositories;

import com.example.remember_app.Models.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional, Long> {
    List<Profesional> findByValidatedTrue();
    List<Profesional> findByValidatedFalse();
    Optional<Profesional> findByEmail(String email);
}
