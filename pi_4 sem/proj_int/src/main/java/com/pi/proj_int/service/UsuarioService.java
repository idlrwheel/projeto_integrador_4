package com.pi.proj_int.service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.pi.proj_int.Model.Usuario;
import com.pi.proj_int.repository.UsuarioRepository;

import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public boolean autenticar(String email, String senhaDigitada) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);

        if (usuarioOpt.isEmpty()) return false;

        Usuario usuario = usuarioOpt.get();

        return passwordEncoder.matches(senhaDigitada, usuario.getSenha());
    }
}