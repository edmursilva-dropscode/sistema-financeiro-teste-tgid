package com.example.sistemafinanceiro.service;

import com.example.sistemafinanceiro.model.ClienteModel;
import com.example.sistemafinanceiro.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<ClienteModel> buscarPorId(Integer id) {
        return clienteRepository.findById(id);
    }

    public ClienteModel salvar(ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }

    public void excluir(Integer id) {
        clienteRepository.deleteById(id);
    }
}

