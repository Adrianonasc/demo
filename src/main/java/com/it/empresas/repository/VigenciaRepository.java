package com.it.empresas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.empresas.model.entities.Vigencia;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VigenciaRepository extends JpaRepository<Vigencia, UUID> {

  @Query("SELECT MAX(e.codigo) + 1 FROM Vigencia e")
  Optional<Long> proximoCodigoEmpresa();
}