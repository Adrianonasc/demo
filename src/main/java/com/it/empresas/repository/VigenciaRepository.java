package com.it.empresas.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

import com.it.empresas.model.entities.Vigencia;

@Repository
public interface VigenciaRepository extends JpaRepository<Vigencia, UUID> {

  @NativeQuery("SELECT IF(MAX(e.CODIGO) is NULL, 1, (MAX(e.codigo) + 1)) a  FROM Empresa2.VIGENCIA e")
  Optional<Long> proximoCodigoEmpresa();
}