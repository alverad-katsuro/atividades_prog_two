package com.system;

import java.util.ArrayList;

public enum Setor {
    REQUISITOS,
    MODELAGEM,
    CODIFICACAO,
    TESTE,
    RECURSOS_HUMANOS;

    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<Contrato> contratos = new ArrayList<>();

    void addFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    void addContrato(Contrato contrato) {
        this.contratos.add(contrato);
    }

    void removeFuncionario(Funcionario funcionario){
        for (int i = 0; i < this.funcionarios.size(); i++) {
            if (funcionario == this.funcionarios.get(i)) {
                this.funcionarios.remove(i);
                break;
            }
        }
    }

    void removeContrato(Contrato contrato){
        for (int i = 0; i < this.contratos.size(); i++) {
            if (contrato == this.contratos.get(i)) {
                this.contratos.remove(i);
                break;
            }
        }
    }

    public ArrayList<Contrato> getContratos() {
        return contratos;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
