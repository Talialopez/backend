package com.example.remember_app.Services;

import com.example.remember_app.Models.CentroMedico;
import com.example.remember_app.Repositories.CentroMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CentroMedicoService {

    @Autowired
    private CentroMedicoRepository centroMedicoRepository;

    public CentroMedico addCentroMedico(CentroMedico centroMedico) {
        return centroMedicoRepository.save(centroMedico);
    }

    @Transactional
    public void deleteCentroMedico(Long id) {
        CentroMedico centroMedico = centroMedicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Centro Médico no encontrado"));
        centroMedicoRepository.delete(centroMedico);
    }

    public List<CentroMedico> getAllCentrosMedicos() {
        return centroMedicoRepository.findAll();
    }
}
