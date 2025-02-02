package com.it.empresas.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.empresas.model.entities.Vigencia;
import com.it.empresas.model.request.CadastroEmpresa;
import com.it.empresas.model.response.VigenciasResponse;
import com.it.empresas.repository.VigenciaRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/empresa")
public class EmpresaController {

  @Autowired
  private VigenciaRepository vigenciaRepository;

  @GetMapping()
  public VigenciasResponse[] listar() {
    log.info("Listando empresas");
    return vigenciaRepository.findAll()
                              .stream()
                              .map(VigenciasResponse::new)
                              .toArray(VigenciasResponse[]::new);
  }

  @PostMapping()
  public void cadastrar(@RequestBody CadastroEmpresa empresa) {
    log.info("Cadastrando empresa {}", empresa.toString());
    // Ficar no Service
    var vigencia = new Vigencia();
    vigencia.setVigenciaId(UUID.randomUUID());
    vigencia.setCodigo(vigenciaRepository.proximoCodigoEmpresa().get());
    vigencia.setCnpj(empresa.getCnpj());
    vigencia.setNomeEmpresa(empresa.getNomeEmpresa());
    //vigenciaRepository.save(vigencia);
    //
  }
}
