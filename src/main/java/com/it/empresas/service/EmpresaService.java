package com.it.empresas.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.empresas.model.entities.Vigencia;
import com.it.empresas.model.request.CadastroEmpresa;
import com.it.empresas.model.response.VigenciasResponse;
import com.it.empresas.repository.VigenciaRepository;

@Service
public class EmpresaService {

  @Autowired
  private VigenciaRepository vigenciaRepository;

  public void cadastrar(CadastroEmpresa empresa) {
    var vigencia = new Vigencia();
    vigencia.setVigenciaId(UUID.randomUUID().toString());
    vigencia.setCodigo(vigenciaRepository.proximoCodigoEmpresa().get());
    vigencia.setCnpj(empresa.getCnpj());
    vigencia.setNomeEmpresa(empresa.getNomeEmpresa());
    vigencia.setDataVigencia(new Date());
    vigenciaRepository.save(vigencia);
  }

  public VigenciasResponse[] listar() {
    return vigenciaRepository.findAll()
                              .stream()
                              .map(VigenciasResponse::new)
                              .toArray(VigenciasResponse[]::new);
  }
  
}
