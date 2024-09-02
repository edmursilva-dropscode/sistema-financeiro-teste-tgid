package com.example.sistemafinanceiro.controller;

import com.example.sistemafinanceiro.model.EmpresaModel;
import com.example.sistemafinanceiro.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<EmpresaModel> listarTodos() {
        return empresaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaModel> buscarPorId(@PathVariable Integer id) {
        Optional<EmpresaModel> empresa = empresaService.buscarPorId(id);
        return empresa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public EmpresaModel salvar(@RequestBody EmpresaModel empresa) {
        return empresaService.salvar(empresa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        empresaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
