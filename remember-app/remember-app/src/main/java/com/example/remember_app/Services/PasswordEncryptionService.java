package com.example.remember_app.Services;

import com.example.remember_app.Models.Profesional;
import com.example.remember_app.Repositories.ProfesionalRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordEncryptionService {

    @Autowired
    private ProfesionalRepository profesionalRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void encryptPasswords() {
        List<Profesional> profesionales = profesionalRepository.findAll();
        for (Profesional profesional : profesionales) {
            // Verifica si la contraseña ya está encriptada
            if (!profesional.getContrasena().startsWith("$2a$")) {
                profesional.setContrasena(passwordEncoder.encode(profesional.getContrasena()));
                profesionalRepository.save(profesional);
            }
        }
    }
}
