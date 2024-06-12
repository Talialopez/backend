package com.example.remember_app.Controlador;

import com.example.remember_app.Models.Paciente;
import com.example.remember_app.Models.Profesional;
import com.example.remember_app.Repositories.PacienteRepository;
import com.example.remember_app.Repositories.ProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ProfesionalRepository profesionalRepository;

    @PreAuthorize("hasRole('PROFESIONAL')")
    @PostMapping("/register")
    public Paciente register(@RequestBody Paciente paciente) {
        Profesional profesional = profesionalRepository.findById(paciente.getProfesional().getIdentificacionUnica())
                .orElseThrow(() -> new RuntimeException("Profesional no encontrado"));

        paciente.setProfesional(profesional);
        return pacienteRepository.save(paciente);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/validate/{dni}")
    public Paciente validate(@PathVariable String dni) {
        Paciente paciente = pacienteRepository.findById(dni)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        paciente.setValidated(true);
        return pacienteRepository.save(paciente);
    }
}
