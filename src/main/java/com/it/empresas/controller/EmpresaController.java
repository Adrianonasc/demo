package com.it.empresas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.empresas.model.request.CadastroEmpresa;
import com.it.empresas.model.response.VigenciasResponse;
import com.it.empresas.service.EmpresaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/empresa")
public class EmpresaController {

  @Autowired
  private EmpresaService empresaService;

  @GetMapping()
  public VigenciasResponse[] listar() {
    log.info("Listando empresas");
    return empresaService.listar();
  }

  @GetMapping("/{cnpj}")
  public VigenciasResponse getbyCNPJ(@PathVariable String cnpj) {
    log.info("Get by empresas");
    return empresaService.getByCNPJ(cnpj);
  }

  @PostMapping()
  public void cadastrar(@RequestBody CadastroEmpresa empresa) {
    log.info("Cadastrando empresa {}", empresa.toString());
    empresaService.cadastrar(empresa);
  }

  @GetMapping("/consulta_receita_federal/{cnpj}")
  public VigenciasResponse ConsultarEmpresaReceita(@PathVariable String cnpj) {
    log.info("Consulta na receita a empresa {}", cnpj);
    return empresaService.consultaReceitaFederal(cnpj);
  }
}
