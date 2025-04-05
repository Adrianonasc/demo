package com.it.empresas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

import com.it.empresas.entities.Vigencia;

@Repository
public interface VigenciaRepository extends JpaRepository<Vigencia, String> {

  @NativeQuery("SELECT IF(MAX(e.CODIGO) is NULL, 1, (MAX(e.codigo) + 1)) a  FROM Empresa2.VIGENCIA e")
  Optional<Long> proximoCodigoEmpresa();
}