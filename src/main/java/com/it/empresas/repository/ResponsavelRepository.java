package com.it.empresas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.empresas.entities.Responsavel;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, String> {
}
