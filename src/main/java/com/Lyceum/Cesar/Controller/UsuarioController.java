package com.Lyceum.Cesar.Controller;


import com.Lyceum.Cesar.Models.Usuario;
import com.Lyceum.Cesar.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*") // Permite que o front acesse
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/cadastro")
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario loginData) {
        return repository.findByMatriculaAndSenha(loginData.getMatricula(), loginData.getSenha())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).build());
    }
}