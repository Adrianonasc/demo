package com.it.empresas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.empresas.repository.VigenciaRepository;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
  
  private static final Logger log = LoggerFactory.getLogger(EmpresaController.class);

  @Autowired
  private VigenciaRepository vigenciaRepository;

  @GetMapping()
  public Object[] listar() {
    return vigenciaRepository.findAll().toArray();
  }
  
}
