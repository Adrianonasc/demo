package com.it.empresas.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "RESPONSAVEL")
public class Responsavel {

    @Id
    @Column(name = "RESPONSAVEL_ID", nullable = false)
    private String responsavelId;

    @Column(name = "VIGENCIA_ID", nullable = false)
    private String vigenciaId;

    @Column(name = "TIPO", nullable = false)
    private int tipo;

    @Column(name = "DATA_VIGENCIA_RESPONSAVEL", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVigenciaResponsavel;

    @Column(name = "NOME")
    private String nome;
}