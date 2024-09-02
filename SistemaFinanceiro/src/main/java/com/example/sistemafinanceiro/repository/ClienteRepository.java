package com.example.sistemafinanceiro.repository;

import com.example.sistemafinanceiro.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {
}


