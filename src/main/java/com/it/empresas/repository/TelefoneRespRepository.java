package com.it.empresas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.empresas.model.entities.TelefoneResp;

import java.util.UUID;

@Repository
public interface TelefoneRespRepository extends JpaRepository<TelefoneResp, UUID> {
}