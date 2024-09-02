package com.example.sistemafinanceiro.controller;

import com.example.sistemafinanceiro.model.TransacaoModel;
import com.example.sistemafinanceiro.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public List<TransacaoModel> listarTodos() {
        return transacaoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransacaoModel> buscarPorId(@PathVariable Integer id) {
        Optional<TransacaoModel> transacao = transacaoService.buscarPorId(id);
        return transacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> realizarTransacao(@RequestParam Integer clienteId,
                                               @RequestParam Integer empresaId,
                                               @RequestParam String tipoTransacao,
                                               @RequestParam Double valor) {
        try {
            transacaoService.realizarTransacao(clienteId, empresaId, tipoTransacao, valor);
            return ResponseEntity.ok("Transação realizada com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/salvar")
    public TransacaoModel salvar(@RequestBody TransacaoModel transacao) {
        return transacaoService.salvar(transacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        transacaoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
