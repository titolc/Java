package com.seulogin.loginapi.controller;

import com.seulogin.loginapi.model.Usuario;
import com.seulogin.loginapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // Libera o CORS para o front
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public String cadastrar(@RequestBody Usuario usuario) {
        // Verifique se os dados estão chegando corretamente
        System.out.println("Cadastro recebido: " + usuario.getEmail() + " - " + usuario.getSenha());

        usuarioService.salvar(usuario); // Salvar o usuário no banco
        return "Cadastro realizado com sucesso!";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String senha = loginRequest.getSenha();

        // Logando os dados recebidos
        System.out.println("Email recebido: " + email);
        System.out.println("Senha recebida: " + senha);

        boolean isAuthenticated = usuarioService.autenticar(email, senha);

        if (isAuthenticated) {
            return ResponseEntity.ok("Login bem-sucedido!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos.");
        }
    }





    // Classe interna para representar a requisição de login
    static class LoginRequest {
        private String email;
        private String senha;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getSenha() { return senha; }
        public void setSenha(String senha) { this.senha = senha; }
        }
}
