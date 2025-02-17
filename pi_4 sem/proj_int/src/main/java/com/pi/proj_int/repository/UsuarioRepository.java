package com.pi.proj_int.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pi.proj_int.Model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}