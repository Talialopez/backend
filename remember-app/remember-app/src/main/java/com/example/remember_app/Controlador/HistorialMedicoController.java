package com.example.remember_app.Controlador;

import com.example.remember_app.Models.HistorialMedico;
import com.example.remember_app.Services.HistorialMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historialmedico")
public class HistorialMedicoController {

    @Autowired
    private HistorialMedicoService historialMedicoService;

    @PostMapping("/agregar")
    public HistorialMedico agregarHistorialMedico(@RequestParam String dniPaciente, @RequestParam String fecha, @RequestParam String motivoConsulta) {
        return historialMedicoService.agregarHistorialMedico(dniPaciente, fecha, motivoConsulta);
    }

    @GetMapping("/paciente/{dni}")
    public List<HistorialMedico> listarHistorialMedico(@PathVariable String dni) {
        return historialMedicoService.listarHistorialMedico(dni);
    }
}
