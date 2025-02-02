package com.it.empresas.model.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CadastroEmpresa {
    private String cnpj;
    private String nomeEmpresa;
}
