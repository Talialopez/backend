package com.example.remember_app.Repositories;

import com.example.remember_app.Models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, String> {
    List<Paciente> findAllByValidated(boolean validated);

    List<Paciente> findByProfesional_IdentificacionUnica(Long identificacionUnica);
}
