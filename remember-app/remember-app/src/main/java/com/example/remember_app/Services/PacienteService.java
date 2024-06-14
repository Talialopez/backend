package com.example.remember_app.Services;

import com.example.remember_app.DTO.PacienteDTO;
import com.example.remember_app.Models.Paciente;
import com.example.remember_app.Models.Profesional;
import com.example.remember_app.Repositories.PacienteRepository;
import com.example.remember_app.Repositories.ProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ProfesionalRepository profesionalRepository;

    public Paciente registerPaciente(PacienteDTO pacienteDTO) {
        Profesional profesional = profesionalRepository.findById(pacienteDTO.getIdentificacionUnica())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profesional no encontrado"));

        Paciente paciente = new Paciente();
        paciente.setDni(pacienteDTO.getDni());
        paciente.setNombre(pacienteDTO.getNombre());
        paciente.setApellido(pacienteDTO.getApellido());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setContrasena(pacienteDTO.getContrasena());
        paciente.setProfesional(profesional);
        paciente.setValidated(false);  // Asegúrate de que el paciente no está validado inicialmente

        return pacienteRepository.save(paciente);
    }

    public Paciente validatePaciente(String dni) {
        Paciente paciente = pacienteRepository.findById(dni)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente no encontrado"));
        paciente.setValidated(true);
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> listarPacientesPendientes() {
        return pacienteRepository.findAllByValidated(false);
    }

    public List<Paciente> listarPacientesValidados() {
        return pacienteRepository.findAllByValidated(true);
    }

}
