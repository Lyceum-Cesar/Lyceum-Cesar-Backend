package com.Lyceum.Cesar.Dto;

import lombok.Data;

@Data
public class DashboardDTO {
    private String disciplinaNome;
    private String codigo;
    private String professorNome;
    private String horario;
    private String sala;
    private Double media;
    private Integer faltas;
}