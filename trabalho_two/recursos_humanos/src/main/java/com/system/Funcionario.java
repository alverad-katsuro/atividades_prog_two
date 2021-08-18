package com.system;

import java.util.Scanner;

import java.util.Date;

public class Funcionario extends Pessoa {
    private Cargo cargo;
    private float salario = 1127.0f;
    private Setor setor;
    private int contrato;
    final Date data_de_ingresso = new Date(System.currentTimeMillis());

    public Funcionario() throws Exception{
        Scanner sc = new Scanner(System.in);
        CadastraFuncionario(sc);
    }

    protected Cargo getCargo() {
        return cargo;
    }

    protected void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
    protected int getContrato() {
        return contrato;
    }

    protected void setContrato(int contrato) {
        this.contrato = contrato;
    }

    protected float getSalario() {
        return salario;
    }

    protected void setSalario(float salario) {
        this.salario = salario;
    }

    protected Setor getSetor() {
        return setor;
    }

    protected void setSetor(Setor setor) {
        this.setor = setor;
    }

    private void CadastraFuncionario(Scanner sc) throws Exception{
        ajustaInformacoes(sc);
    }
}
