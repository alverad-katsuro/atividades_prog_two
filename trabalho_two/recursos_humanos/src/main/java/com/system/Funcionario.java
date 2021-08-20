package com.system;

import java.util.Scanner;

import java.util.Date;
import java.util.UUID;

public class Funcionario extends Pessoa {
    private Cargo cargo;
    private float salario = 1127.0f;
    private Setor setor;
    private UUID contrato;
    final Date data_de_ingresso = new Date(System.currentTimeMillis());
    private static int numero_de_funcionarios = 0;

    public Funcionario(Scanner sc) throws Exception{
        ajustaNomeCPF(sc);
        CadastraFuncionario(sc);
        ajustaInformacoes(sc);
        definirEndereco(sc);
        modify_Numero_de_funcionarios(1);
    }

    protected Cargo getCargo() {
        return cargo;
    }

    protected void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
    protected UUID getContrato() {
        return contrato;
    }

    protected void setContrato(UUID contrato) {
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

    protected static void modify_Numero_de_funcionarios(int number) {
        Funcionario.numero_de_funcionarios += number;
    }

    public static int getNumero_de_funcionarios() {
        return numero_de_funcionarios;
    }

    private void CadastraFuncionario(Scanner sc) throws Exception{
        ajustaInformacoes(sc);
    }
}
