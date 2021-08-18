package com.system;

public class Funcionario {
    private Cargo cargo;
    private float salario = 1127.0f;
    private Setor setor;
    private int Contrato;

    public Cargo getCargo() {
        return cargo;
    }
    
    public int getContrato() {
        return Contrato;
    }

    public float getSalario() {
        return salario;
    }

    public Setor getSetor() {
        return setor;
    }
}
