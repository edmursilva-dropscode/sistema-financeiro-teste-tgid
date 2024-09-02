package com.example.sistemafinanceiro.service;

import com.example.sistemafinanceiro.model.EmpresaModel;
import com.example.sistemafinanceiro.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<EmpresaModel> listarTodos() {
        return empresaRepository.findAll();
    }

    public Optional<EmpresaModel> buscarPorId(Integer id) {
        return empresaRepository.findById(id);
    }

    public EmpresaModel salvar(EmpresaModel empresa) {
        return empresaRepository.save(empresa);
    }

    public void excluir(Integer id) {
        empresaRepository.deleteById(id);
    }
}

