package com.example.remember_app.Controlador;

import com.example.remember_app.DTO.FichaMedicaDTO;
import com.example.remember_app.Models.FichaMedica;
import com.example.remember_app.Services.FichaMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fichamedica")
public class FichaMedicaController {

    @Autowired
    private FichaMedicaService fichaMedicaService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/agregar")
    public FichaMedica agregarFichaMedica(@RequestBody FichaMedicaDTO fichaMedicaDTO) {
        return fichaMedicaService.agregarFichaMedica(fichaMedicaDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{dni}")
    public void eliminarFichaMedica(@PathVariable String dni) {
        fichaMedicaService.eliminarFichaMedicaPorDniPaciente(dni);
    }

    @GetMapping("/paciente/{dni}")
    public FichaMedica obtenerFichaMedicaPorDniPaciente(@PathVariable String dni) {
        return fichaMedicaService.obtenerFichaMedicaPorDniPaciente(dni);
    }
}
