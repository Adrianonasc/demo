package com.it.empresas.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "VIGENCIA")
public class Vigencia {

    @Id
    @Column(name = "VIGENCIA_ID", nullable = false)
    private UUID vigenciaId;

    @Column(name = "CODIGO", nullable = false)
    private int codigo;

    @Column(name = "DATA_VIGENCIA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVigencia;

    @Column(name = "CNPJ", nullable = false)
    private String cnpj;

    @Column(name = "NOME_EMPRESA", nullable = false)
    private String nomeEmpresa;
}
