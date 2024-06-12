package com.example.remember_app.Repositories;

import com.example.remember_app.Models.CentroMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentroMedicoRepository extends JpaRepository<CentroMedico, Long> {
}
