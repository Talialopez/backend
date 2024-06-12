package com.example.remember_app.Controlador;

import com.example.remember_app.DTO.CentroMedicoDTO;
import com.example.remember_app.Models.CentroMedico;
import com.example.remember_app.Services.CentroMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/centrosmedicos")
public class CentroMedicoController {

    @Autowired
    private CentroMedicoService centroMedicoService;

    @GetMapping
    public List<CentroMedico> getAllCentrosMedicos() {
        return centroMedicoService.getAllCentrosMedicos();
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CentroMedico> addCentroMedico(@RequestBody CentroMedicoDTO centroMedicoDTO) {
        CentroMedico centroMedico = new CentroMedico();
        centroMedico.setNombre(centroMedicoDTO.getNombre());
        CentroMedico savedCentroMedico = centroMedicoService.addCentroMedico(centroMedico);
        return new ResponseEntity<>(savedCentroMedico, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteCentroMedico(@PathVariable Long id) {
        centroMedicoService.deleteCentroMedico(id);
        return ResponseEntity.noContent().build();
    }
}
