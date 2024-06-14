package com.example.remember_app.Services;

import com.example.remember_app.DTO.FichaMedicaDTO;
import com.example.remember_app.Models.FichaMedica;
import com.example.remember_app.Models.Paciente;
import com.example.remember_app.Repositories.FichaMedicaRepository;
import com.example.remember_app.Repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FichaMedicaService {

    @Autowired
    private FichaMedicaRepository fichaMedicaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional
    public FichaMedica agregarFichaMedica(FichaMedicaDTO fichaMedicaDTO) {
        Paciente paciente = pacienteRepository.findById(fichaMedicaDTO.getDniPaciente())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente no encontrado"));

        if (paciente.getFichaMedica() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El paciente ya tiene una ficha médica");
        }

        FichaMedica fichaMedica = new FichaMedica();
        fichaMedica.setNombreCompleto(fichaMedicaDTO.getNombreCompleto());
        fichaMedica.setEdad(fichaMedicaDTO.getEdad());
        fichaMedica.setGenero(fichaMedicaDTO.getGenero());
        fichaMedica.setFechaNacimiento(fichaMedicaDTO.getFechaNacimiento());
        fichaMedica.setTipoSangre(fichaMedicaDTO.getTipoSangre());
        fichaMedica.setEps(fichaMedicaDTO.getEps());
        fichaMedica.setDireccionResidencia(fichaMedicaDTO.getDireccionResidencia());
        fichaMedica.setPeso(fichaMedicaDTO.getPeso());
        fichaMedica.setEstatura(fichaMedicaDTO.getEstatura());
        fichaMedica.setEsquemaVacunacion(fichaMedicaDTO.getEsquemaVacunacion());
        fichaMedica.setEnfermedadesOjos(fichaMedicaDTO.getEnfermedadesOjos());
        fichaMedica.setLentesPermanentes(fichaMedicaDTO.getLentesPermanentes());
        fichaMedica.setProtesis(fichaMedicaDTO.getProtesis());
        fichaMedica.setAlergias(fichaMedicaDTO.getAlergias());
        fichaMedica.setCirugias(fichaMedicaDTO.getCirugias());
        fichaMedica.setCondicionesEspeciales(fichaMedicaDTO.getCondicionesEspeciales());
        fichaMedica.setDiabetes(fichaMedicaDTO.getDiabetes());
        fichaMedica.setCancer(fichaMedicaDTO.getCancer());
        fichaMedica.setHipertension(fichaMedicaDTO.getHipertension());
        fichaMedica.setEnfermedadesCardiovasculares(fichaMedicaDTO.getEnfermedadesCardiovasculares());
        fichaMedica.setOtrasEnfermedades(fichaMedicaDTO.getOtrasEnfermedades());
        fichaMedica.setPaciente(paciente);

        return fichaMedicaRepository.save(fichaMedica);
    }

    public FichaMedica obtenerFichaMedicaPorDniPaciente(String dniPaciente) {
        return fichaMedicaRepository.findByPacienteDni(dniPaciente)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ficha médica no encontrada para el paciente con DNI: " + dniPaciente));
    }
}
