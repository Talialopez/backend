package com.example.remember_app.Repositories;

import com.example.remember_app.Models.FichaMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FichaMedicaRepository extends JpaRepository<FichaMedica, Long> {
    Optional<FichaMedica> findByPacienteDni(String dni);

}
