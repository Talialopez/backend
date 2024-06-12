package com.example.remember_app.Services;

import com.example.remember_app.Models.CentroMedico;
import com.example.remember_app.Models.Profesional;
import com.example.remember_app.Repositories.CentroMedicoRepository;
import com.example.remember_app.Repositories.ProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProfesionalService {

    @Autowired
    private ProfesionalRepository profesionalRepository;

    @Autowired
    private CentroMedicoRepository centroMedicoRepository;

    public void register(Profesional profesional, Long centroMedicoId) {
        CentroMedico centroMedico = centroMedicoRepository.findById(centroMedicoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Centro Médico no encontrado"));
        profesional.setCentroMedico(centroMedico);
        profesional.setValidated(false);
        profesionalRepository.save(profesional);
    }

    public void validate(Long id) {
        Profesional profesional = profesionalRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profesional no encontrado con ID: " + id));
        profesional.setValidated(true);
        profesionalRepository.save(profesional);
    }

    public List<Profesional> getPendientes() {
        return profesionalRepository.findByValidatedFalse();
    }

    public List<Profesional> getValidados() {
        return profesionalRepository.findByValidatedTrue();
    }
}
