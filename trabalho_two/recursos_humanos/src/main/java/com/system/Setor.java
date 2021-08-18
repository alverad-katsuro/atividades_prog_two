package com.system;

import java.util.ArrayList;
import java.util.UUID;

public enum Setor {
    REQUISITOS,
    MODELAGEM,
    CODIFICACAO,
    TESTE,
    RECURSOS_HUMANOS;

    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<UUID> contratos = new ArrayList<>();
    private Funcionario chefe;

    public void setChefe(Funcionario chefe) {
        this.chefe = chefe;
    }

    public Funcionario getChefe() {
        return this.chefe;
    }

    void addFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    void addFuncionario() throws Exception {
        Funcionario funcionario = new Funcionario();
        this.funcionarios.add(funcionario);
    }

    boolean removeFuncionario(Funcionario funcionario){
        for (int i = 0; i < this.funcionarios.size(); i++) {
            if (funcionario == this.funcionarios.get(i)) {
                this.funcionarios.remove(i);
                return true;
            }
        }
        return false;
    }

    void addContrato(UUID contrato) {
        this.contratos.add(contrato);
    }
    
    public ArrayList<UUID> getContratos() {
        return contratos;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
