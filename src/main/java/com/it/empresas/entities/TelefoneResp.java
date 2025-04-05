package com.it.empresas.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "TELEFONE_RESP")
public class TelefoneResp {

    @Id
    @Column(name = "TELEFONE_ID", nullable = false)
    private String telefoneId;

    @Column(name = "RESPONSAVEL_ID", nullable = false)
    private String responsavelId;

    @Column(name = "DATA_VIGENCIA_TELEFONE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVigenciaTelefone;

    @Column(name = "TELEFONE", nullable = false)
    private String telefone;
}
