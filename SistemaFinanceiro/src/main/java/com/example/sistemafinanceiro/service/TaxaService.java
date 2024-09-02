package com.example.sistemafinanceiro.service;

import com.example.sistemafinanceiro.model.TaxaModel;
import com.example.sistemafinanceiro.repository.TaxaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaxaService {

    @Autowired
    private TaxaRepository taxaRepository;

    public List<TaxaModel> listarTodos() {
        return taxaRepository.findAll();
    }

    public Optional<TaxaModel> buscarPorId(Integer id) {
        return taxaRepository.findById(id);
    }

    public TaxaModel salvar(TaxaModel taxa) {
        return taxaRepository.save(taxa);
    }

    public void excluir(Integer id) {
        taxaRepository.deleteById(id);
    }
}
