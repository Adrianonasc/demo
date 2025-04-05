package com.it.empresas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.empresas.entities.TelefoneResp;

@Repository
public interface TelefoneRespRepository extends JpaRepository<TelefoneResp, String> {
}