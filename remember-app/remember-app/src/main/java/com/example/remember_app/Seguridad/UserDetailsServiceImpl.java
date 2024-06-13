package com.example.remember_app.Seguridad;

import com.example.remember_app.Models.Administrador;
import com.example.remember_app.Models.Profesional;
import com.example.remember_app.Repositories.AdministradorRepository;
import com.example.remember_app.Repositories.ProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private ProfesionalRepository profesionalRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Primero, intentamos cargar el administrador
        Administrador admin = administradorRepository.findByUsername(username)
                .orElse(null);

        if (admin != null) {
            return User.withUsername(admin.getUsername())
                    .password(admin.getPassword())
                    .roles(admin.getRole())
                    .build();
        }

        // Si no se encuentra el administrador, intentamos cargar el profesional
        Profesional profesional = profesionalRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con nombre: " + username));

        return User.withUsername(profesional.getEmail())
                .password(profesional.getContrasena())
                .roles("PROFESIONAL")
                .build();
    }
}
