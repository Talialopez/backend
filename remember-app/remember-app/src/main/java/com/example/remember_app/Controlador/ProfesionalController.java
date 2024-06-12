package com.example.remember_app.Controlador;

import com.example.remember_app.Models.Profesional;
import com.example.remember_app.Services.ProfesionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesionales")
public class ProfesionalController {

    @Autowired
    private ProfesionalService profesionalService;

    @PostMapping("/register")
    public ResponseEntity<Profesional> registerProfesional(@RequestBody Profesional profesional) {
        Long centroMedicoId = profesional.getCentroMedico().getId();
        profesionalService.register(profesional, centroMedicoId);

        return new ResponseEntity<>(profesional, HttpStatus.CREATED);
    }

    @PostMapping("/validate/{id}")
    public ResponseEntity<String> validateProfesional(@PathVariable Long id) {
        profesionalService.validate(id);
        return new ResponseEntity<>("Profesional validado exitosamente", HttpStatus.OK);
    }

    @GetMapping("/pendientes")
    public List<Profesional> getProfesionalesPendientes() {
        return profesionalService.getPendientes();
    }

    @GetMapping("/validados")
    public List<Profesional> getProfesionalesValidados() {
        return profesionalService.getValidados();
    }
}
