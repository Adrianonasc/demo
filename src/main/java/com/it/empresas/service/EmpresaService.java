package com.it.empresas.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.it.empresas.entities.Vigencia;
import com.it.empresas.model.request.CadastroEmpresa;
import com.it.empresas.model.response.VigenciasResponse;
import com.it.empresas.repository.VigenciaRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class EmpresaService {

  @Autowired
  private VigenciaRepository vigenciaRepository;

  @Autowired
  private GovConsumer govConsumer;

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

  public VigenciasResponse consultaReceitaFederal(String cnpj) {
    return govConsumer.consultaReceitaFederal(cnpj);
  }

  public VigenciasResponse getByCNPJ(String cnpj) {
    Vigencia vigencia = new Vigencia();
    vigencia.setCnpj(cnpj);

    Example<Vigencia> example = Example.of(vigencia);
    return new VigenciasResponse(vigenciaRepository.findOne(example).get());
  }
  
}
