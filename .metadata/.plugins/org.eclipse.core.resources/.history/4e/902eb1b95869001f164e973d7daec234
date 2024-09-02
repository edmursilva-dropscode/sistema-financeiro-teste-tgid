package com.example.sistemafinanceiro.controller;

import com.example.sistemafinanceiro.model.TaxaModel;
import com.example.sistemafinanceiro.service.TaxaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/taxas")
public class TaxaController {

    @Autowired
    private TaxaService taxaService;

    @GetMapping
    public List<TaxaModel> listarTodos() {
        return taxaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaxaModel> buscarPorId(@PathVariable Integer id) {
        Optional<TaxaModel> taxa = taxaService.buscarPorId(id);
        return taxa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TaxaModel salvar(@RequestBody TaxaModel taxa) {
        return taxaService.salvar(taxa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        taxaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

