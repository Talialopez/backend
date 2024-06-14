package com.example.remember_app.Controlador;

import com.example.remember_app.DTO.PacienteDTO;
import com.example.remember_app.Models.Paciente;
import com.example.remember_app.Services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/register")
    public Paciente register(@RequestBody PacienteDTO pacienteDTO) {
        return pacienteService.registerPaciente(pacienteDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/validate/{dni}")
    public Paciente validate(@PathVariable String dni) {
        return pacienteService.validatePaciente(dni);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/pendientes")
    public List<Paciente> listarPacientesPendientes() {
        return pacienteService.listarPacientesPendientes();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/validados")
    public List<Paciente> listarPacientesValidados() {
        return pacienteService.listarPacientesValidados();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{dni}")
    public void eliminar(@PathVariable String dni) {
        pacienteService.eliminarPaciente(dni);
    }
}
