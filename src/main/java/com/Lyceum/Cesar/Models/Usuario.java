package com.Lyceum.Cesar.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;

    @Column(unique = true)
    private String emailInstitucional;

    private String senha;

    @Column(unique = true)
    private String matricula;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    public enum TipoUsuario {
        ALUNO, PROFESSOR
    }
}