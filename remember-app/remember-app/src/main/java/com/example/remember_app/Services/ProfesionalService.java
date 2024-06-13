package com.example.remember_app.Services;

import com.example.remember_app.Models.CentroMedico;
import com.example.remember_app.Models.Profesional;
import com.example.remember_app.DTO.ProfesionalDTO;
import com.example.remember_app.Repositories.CentroMedicoRepository;
import com.example.remember_app.Repositories.ProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProfesionalService {

    @Autowired
    private ProfesionalRepository profesionalRepository;

    @Autowired
    private CentroMedicoRepository centroMedicoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Profesional register(ProfesionalDTO profesionalDTO) {
        CentroMedico centroMedico = centroMedicoRepository.findById(profesionalDTO.getCentroMedicoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Centro Médico no encontrado"));

        Profesional profesional = new Profesional();
        profesional.setIdentificacionUnica(profesionalDTO.getIdentificacionUnica());
        profesional.setNombre(profesionalDTO.getNombre());
        profesional.setApellido(profesionalDTO.getApellido());
        profesional.setEmail(profesionalDTO.getEmail());
        profesional.setContrasena(passwordEncoder.encode(profesionalDTO.getContrasena()));
        profesional.setCentroMedico(centroMedico);
        profesional.setValidated(false);

        return profesionalRepository.save(profesional);
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
