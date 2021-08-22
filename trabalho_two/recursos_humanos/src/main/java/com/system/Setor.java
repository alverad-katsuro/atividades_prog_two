package com.system;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Scanner;

public enum Setor {
    REQUISITOS,
    MODELAGEM,
    CODIFICACAO,
    TESTE,
    RECURSOS_HUMANOS;

    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<UUID> contratos = new ArrayList<>();
    private Funcionario chefe;

    protected void setChefe(Funcionario chefe) {
        this.chefe = chefe;
    }

    protected void setChefe(Scanner sc) throws Exception {
        this.chefe = new Funcionario(sc);
    }

    protected Funcionario getChefe() {
        return this.chefe;
    }

    void addFuncionario(Funcionario funcionario) {
        getFuncionarios().add(funcionario);
    }

    void addFuncionario(Scanner sc) throws Exception {
        Funcionario funcionario = new Funcionario(sc);
        addFuncionario(funcionario);
    }

    boolean removeFuncionario(Funcionario funcionario){
        for (int i = 0; i < getFuncionarios().size(); i++) {
            if (funcionario == getFuncionarios().get(i)) {
                getFuncionarios().remove(i);
                return true;
            }
        }
        return false;
    }

    void addContrato(UUID contrato) {
        getContratos().add(contrato);
    }
    
    public ArrayList<UUID> getContratos() {
        return contratos;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
