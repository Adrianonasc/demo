package com.it.empresas.model.response;

import java.util.Date;

import com.it.empresas.entities.Vigencia;

public record VigenciasResponse(
    Long codigo,
    Date dataVigencia,
    String cnpj,
    String nomeEmpresa
) {
    public VigenciasResponse(Vigencia vigencia) {
        this(vigencia.getCodigo(), vigencia.getDataVigencia(), vigencia.getCnpj(), vigencia.getNomeEmpresa());
    }
}
