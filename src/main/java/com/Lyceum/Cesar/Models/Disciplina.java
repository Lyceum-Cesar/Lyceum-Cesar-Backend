package com.Lyceum.Cesar.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String codigo;
    private String sala;
    private String horario;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Usuario professor;
}