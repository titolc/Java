package com.seulogin.loginapi.service;

import com.seulogin.loginapi.model.Usuario;
import com.seulogin.loginapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean autenticar(String email, String senha) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();

            // Logando a senha recebida no login e a senha armazenada no banco
            System.out.println("Senha recebida no login: " + senha);  // Senha recebida no login
            System.out.println("Senha armazenada no banco: " + usuario.getSenha());  // Senha criptografada no banco

            // Verificando a comparação de senha
            boolean matches = passwordEncoder.matches(senha, usuario.getSenha());

            System.out.println("A senha fornecida corresponde à senha criptografada? " + matches);  // Resultado da comparação

            return matches;
        }

        return false;
    }







    public void salvar(Usuario usuario) {
        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);  // Criptografando a senha antes de salvar
        usuarioRepository.save(usuario);
    }


}
