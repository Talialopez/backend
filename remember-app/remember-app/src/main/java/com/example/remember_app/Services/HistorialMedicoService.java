package com.example.remember_app.Services;

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

    public HistorialMedico agregarHistorialMedico(String dniPaciente, String fecha, String motivoConsulta) {
        Paciente paciente = pacienteRepository.findById(dniPaciente)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente no encontrado"));

        HistorialMedico historialMedico = new HistorialMedico();
        historialMedico.setFecha(fecha);
        historialMedico.setMotivoConsulta(motivoConsulta);
        historialMedico.setPaciente(paciente);

        return historialMedicoRepository.save(historialMedico);
    }

    public List<HistorialMedico> listarHistorialMedico(String dniPaciente) {
        return historialMedicoRepository.findByPacienteDni(dniPaciente);
    }
}
