package com.example.sistemafinanceiro.service;

import com.example.sistemafinanceiro.model.TransacaoModel; // Classe de modelo TransacaoModel
import com.example.sistemafinanceiro.repository.TransacaoRepository; // Repositório para a entidade TransacaoModel
import com.example.sistemafinanceiro.model.EmpresaModel; // Classe de modelo EmpresaModel
import com.example.sistemafinanceiro.model.TaxaModel; // Classe de modelo TaxaModel
import com.example.sistemafinanceiro.repository.EmpresaRepository; // Repositório para a entidade EmpresaModel
import com.example.sistemafinanceiro.repository.TaxaRepository; // Repositório para a entidade TaxaModel
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private EmpresaRepository empresaRepository; // Injeção do repositório EmpresaModel

    @Autowired
    private TransacaoRepository transacaoRepository; // Injeção do repositório TransacaoModel

    @Autowired
    private TaxaRepository taxaRepository; // Injeção do repositório TaxaModel

    public void realizarTransacao(Integer clienteId, Integer empresaId, String tipoTransacao, Double valor) throws Exception {
        Optional<EmpresaModel> empresaOpt = empresaRepository.findById(empresaId);
        if (!empresaOpt.isPresent()) {
            throw new Exception("Empresa não encontrada.");
        }

        EmpresaModel empresa = empresaOpt.get(); // Obtenção da empresa
        if ("SAQUE".equals(tipoTransacao) && empresa.getSaldo() < valor) {
            throw new Exception("Saldo insuficiente na empresa.");
        }

        Optional<TaxaModel> taxaOpt = taxaRepository.findById(empresaId);
        if (!taxaOpt.isPresent()) {
            throw new Exception("Taxa não encontrada para a empresa.");
        }

        TaxaModel taxa = taxaOpt.get(); // Obtenção da taxa
        Double valorFinal = valor + (valor * taxa.getValor() / 100);

        // Atualizar saldo da empresa
        if ("DEPOSITO".equals(tipoTransacao)) {
            empresa.setSaldo(empresa.getSaldo() + valor);
        } else if ("SAQUE".equals(tipoTransacao)) {
            empresa.setSaldo(empresa.getSaldo() - valorFinal);
        }

        empresaRepository.save(empresa); // Salvamento da empresa atualizada

        // Salvar transação
        TransacaoModel transacao = new TransacaoModel();
        transacao.setTipo(tipoTransacao);
        transacao.setValor(valor);
        transacao.setClienteId(clienteId);
        transacao.setEmpresaId(empresaId);
        transacaoRepository.save(transacao); // Salvamento da transação

        // Simular envio de callback e notificação
        enviarCallback(empresaId, transacao);
        enviarNotificacao(clienteId, transacao);
    }

    public List<TransacaoModel> listarTodos() {
        return transacaoRepository.findAll();
    }

    public Optional<TransacaoModel> buscarPorId(Integer id) {
        return transacaoRepository.findById(id);
    }

    public TransacaoModel salvar(TransacaoModel transacao) {
        return transacaoRepository.save(transacao);
    }

    public void excluir(Integer id) {
        transacaoRepository.deleteById(id);
    }

    private void enviarCallback(Integer empresaId, TransacaoModel transacao) {
        // Simulação de envio de callback
        // Use webhook.site para testar
    }

    private void enviarNotificacao(Integer clienteId, TransacaoModel transacao) {
        // Simulação de envio de notificação
        // Pode ser por e-mail ou SMS
    }
}
