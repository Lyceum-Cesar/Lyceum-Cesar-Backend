package com.Lyceum.Cesar.Repository;

import com.Lyceum.Cesar.Models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByMatriculaAndSenha(String matricula, String senha);
}
