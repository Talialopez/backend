package com.example.remember_app.Services;

import com.example.remember_app.DTO.HistorialMedicoDTO;
import com.example.remember_app.Models.HistorialMedico;
import com.example.remember_app.Models.Paciente;
import com.example.remember_app.Repositories.HistorialMedicoRepository;
import com.example.remember_app.Repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class HistorialMedicoService {

    @Autowired
    private HistorialMedicoRepository historialMedicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public void agregarHistorialMedico(HistorialMedicoDTO historialMedicoDTO) {
        Paciente paciente = pacienteRepository.findById(historialMedicoDTO.getDniPaciente())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente no encontrado"));

        HistorialMedico historialMedico = new HistorialMedico();
        historialMedico.setFecha(historialMedicoDTO.getFecha());
        historialMedico.setMotivoConsulta(historialMedicoDTO.getMotivoConsulta());
        historialMedico.setPaciente(paciente);

        historialMedicoRepository.save(historialMedico);
    }

    public List<HistorialMedico> listarHistorialMedico(String dniPaciente) {
        return historialMedicoRepository.findByPacienteDni(dniPaciente);
    }
}
