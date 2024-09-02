package com.example.sistemafinanceiro.repository;

import com.example.sistemafinanceiro.model.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<EmpresaModel, Integer> {
}