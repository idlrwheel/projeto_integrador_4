package com.pi.proj_int.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pi.proj_int.service.UsuarioService;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
public class LoginController {
    private final UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        boolean autenticado = usuarioService.autenticar(loginRequest.getEmail(), loginRequest.getSenha());

        if (!autenticado) {
            return ResponseEntity.status(401).body("Credenciais inválidas ou acesso negado.");
        }

        session.setAttribute("usuario", loginRequest.getEmail());
        return ResponseEntity.ok("Login realizado com sucesso.");
    }
}

class LoginRequest {
    private String email;
    private String senha;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    };
}