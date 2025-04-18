package com.it.empresas.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "VIGENCIA")
public class Vigencia {

    @Id
    @Column(name = "VIGENCIA_ID", nullable = false)
    private String vigenciaId;

    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @Column(name = "DATA_VIGENCIA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVigencia;

    @Column(name = "CNPJ", nullable = false)
    private String cnpj;

    @Column(name = "NOME_EMPRESA", nullable = false)
    private String nomeEmpresa;
}
