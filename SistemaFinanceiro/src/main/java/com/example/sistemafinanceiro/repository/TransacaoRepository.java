package com.example.sistemafinanceiro.repository;

import com.example.sistemafinanceiro.model.TransacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<TransacaoModel, Integer> {
}
