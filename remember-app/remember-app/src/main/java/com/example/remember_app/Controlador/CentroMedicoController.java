package com.example.remember_app.Controlador;

import com.example.remember_app.Models.CentroMedico;
import com.example.remember_app.Repositories.CentroMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/centrosmedicos")
public class CentroMedicoController {

    @Autowired
    private CentroMedicoRepository centroMedicoRepository;

    @GetMapping
    public List<CentroMedico> getAllCentrosMedicos() {
        return centroMedicoRepository.findAll();
    }
}
