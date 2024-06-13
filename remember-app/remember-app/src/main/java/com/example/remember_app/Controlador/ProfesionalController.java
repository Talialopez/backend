package com.example.remember_app.Controlador;

import com.example.remember_app.Models.AuthRequest;
import com.example.remember_app.Services.AuthService;
import com.example.remember_app.Services.ProfesionalService;
import com.example.remember_app.Models.Profesional;
import com.example.remember_app.DTO.ProfesionalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/profesionales")
public class ProfesionalController {

    @Autowired
    private AuthService authService;

    @Autowired
    private ProfesionalService profesionalService;

    @PostMapping("/register")
    public ResponseEntity<Profesional> registerProfesional(@RequestBody ProfesionalDTO profesionalDTO) {
        Profesional profesional = profesionalService.register(profesionalDTO);
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

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody AuthRequest authRequest) {
        return authService.login(authRequest.getEmail(), authRequest.getPassword());
    }

}
