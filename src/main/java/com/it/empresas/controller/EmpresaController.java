package com.it.empresas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

  @PostMapping()
  public void cadastrar(@RequestBody CadastroEmpresa empresa) {
    log.info("Cadastrando empresa {}", empresa.toString());
    empresaService.cadastrar(empresa);
  }
}
