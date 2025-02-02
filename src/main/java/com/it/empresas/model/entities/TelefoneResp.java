package com.it.empresas.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "TELEFONE_RESP")
public class TelefoneResp {

    @Id
    @Column(name = "TELEFONE_ID", nullable = false)
    private UUID telefoneId;

    @Column(name = "RESPONSAVEL_ID", nullable = false)
    private UUID responsavelId;

    @Column(name = "DATA_VIGENCIA_TELEFONE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVigenciaTelefone;

    @Column(name = "TELEFONE", nullable = false)
    private String telefone;

    // Getters and Setters
}
