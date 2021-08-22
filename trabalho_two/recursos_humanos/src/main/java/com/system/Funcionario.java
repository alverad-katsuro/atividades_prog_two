package com.system;

import java.util.Scanner;

import java.util.Date;
import java.util.UUID;

public class Funcionario extends Pessoa {
    private Cargo cargo;
    private final float salario_minimo = 1127.0f;
    private float salario;
    private Setor setor;
    private UUID contrato;
    final Date data_de_ingresso = new Date(System.currentTimeMillis());
    private static int numero_de_funcionarios = 0;
    private final UUID matricula = UUID.randomUUID();

    public Funcionario(Scanner sc) throws Exception{
        defineNome(sc);
        defineCPF(sc);
        defineSexo(sc);
        defineDataNascimento(sc);
        defineEmail(sc);
        defineEndereco(sc);
        defineSalario(sc);
        defineTelefone(sc);
        modify_Numero_de_funcionarios(1);
        System.out.println("Matricula ID: "+ getMatricula());
    }

    public UUID getMatricula() {
        return matricula;
    }

    public Date getData_de_ingresso() {
        return data_de_ingresso;
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

    private void setSalario(float salario) throws Exception {
        if (salario < salario_minimo) {
            throw new Exception("SALARIO INFERIOR AO SALARIO MINIMO");
        }
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

    protected void defineSalario(Scanner sc) throws Exception{
        System.out.printf("Digite o salario do funcionario: ");
        setSalario(sc.nextFloat());
    }
}
