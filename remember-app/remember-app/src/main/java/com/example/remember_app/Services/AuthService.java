package com.example.remember_app.Services;

import com.example.remember_app.Models.Paciente;
import com.example.remember_app.Models.Profesional;
import com.example.remember_app.Repositories.PacienteRepository;
import com.example.remember_app.Repositories.ProfesionalRepository;
import com.example.remember_app.Seguridad.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthService {

    @Autowired
    private ProfesionalRepository profesionalRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private TokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public ResponseEntity<Map<String, Object>> login(String email, String password) {
        Profesional profesional = profesionalRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales incorrectas"));

        if (!profesional.isValidated()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Cuenta no validada");
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtTokenProvider.generateToken(userDetails);

        // Obtener la lista de pacientes asociados con el profesional
        List<Paciente> pacientes = pacienteRepository.findByProfesional(profesional);

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("validated", profesional.isValidated());
        response.put("nombre", profesional.getNombre());
        response.put("pacientes", pacientes); // Añadir la lista de pacientes a la respuesta
        response.put("profesionalId", profesional.getIdentificacionUnica()); // Añadir profesionalId a la respuesta

        return ResponseEntity.ok(response);
    }
}
