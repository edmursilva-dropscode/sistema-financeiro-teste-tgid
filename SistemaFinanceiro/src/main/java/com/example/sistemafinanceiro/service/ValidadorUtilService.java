package com.example.sistemafinanceiro.service;

public class ValidadorUtilService {

    public static boolean validarCPF(String cpf) {
        // Implementação simples de validação de CPF
        if (cpf == null || cpf.length() != 11) {
            return false;
        }
        // Adicione a lógica real de validação aqui
        return true;
    }

    public static boolean validarCNPJ(String cnpj) {
        // Implementação simples de validação de CNPJ
        if (cnpj == null || cnpj.length() != 14) {
            return false;
        }
        // Adicione a lógica real de validação aqui
        return true;
    }
}
