package com.system;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Pessoa extends Atributos_Comuns{
    private int cpf;
    private boolean sexo;
    private int idade;
    private int dia;
    private int mes;
    private int ano;

    public Pessoa(String nome, int cpf) throws Exception {
        setNome(nome);
        setCpf(cpf);
    }

    protected Pessoa() {
        System.out.println("Não tenho nome ainda!");
    }

    protected  void ajustaNomeCPF(Scanner sc) throws Exception {
        System.out.printf("Digite o nome da pessoa: ");
        setNome(sc.nextLine());
        System.out.printf("Digite o cpf da pessoa: ");
        setCpf(sc.nextInt());
    }

    protected  void ajustaInformacoes(Scanner sc) throws Exception {
        System.out.printf("Digite o sexo da pessoa\n0. Masculino\n1.Feminino\n Resposta: ");
        setSexo(sc.nextBoolean());
        System.out.printf("Digite o dia de nascimento: ");
        setDia(sc.nextInt());
        System.out.printf("Digite o mes de nascimento: ");
        setMes(sc.nextInt());
        System.out.printf("Digite o ano de nascimento: ");
        setAno(sc.nextInt());
    }

    protected void calculaIdade() {
        int dia, mes, ano;
        SimpleDateFormat format_year = new SimpleDateFormat("yyyy");
        SimpleDateFormat format_mouth = new SimpleDateFormat("MM");
        SimpleDateFormat format_day = new SimpleDateFormat("dd");
        Date date = new Date(System.currentTimeMillis());
        ano = Integer.parseInt(format_year.format(date).toString());
        mes = Integer.parseInt(format_mouth.format(date).toString());
        dia = Integer.parseInt(format_day.format(date).toString());
        if (getMes() > mes) {
            setIdade((short)(ano - getAno()));
            System.out.printf("A idade do %s é %d anos%n", getNome(), getIdade());
        } else if (mes == getMes()) {
            if (dia >= getDia()){
                setIdade((short)(ano - getAno()));
                System.out.printf("A idade do %s é %d anos%n", getNome(), getIdade());
            }
        } else if (mes > getMes()) {
            setIdade((short) (ano - getAno() - 1));
            System.out.printf("A idade do %s é %d anos%n", getNome(), getIdade());
        }
    }

    protected void setDia(int dia) throws Exception {
        if (dia < 0 || dia > 31) {
            throw new Exception("Dia invalido");
        }
        this.dia = dia;
    }

    protected int getDia() {
        return dia;
    }

    protected void setMes(int mes) throws Exception{
        if (mes < 0 || mes > 12) {
            throw new Exception("Mes invalido");
        }
        this.mes = mes;
    }

    protected int getMes() {
        return mes;
    }

    protected void setAno(int ano) throws Exception{
        if (ano < 0 || ano > 2021) {
            throw new Exception("Ano invalido");
        }
        this.ano = ano;
    }

    protected int getAno() {
        return ano;
    }

    protected void setIdade(int idade) {
        this.idade = idade;
    }

    protected int getIdade() {
        return idade;
    }

    protected void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    protected boolean getSexo(){
        return this.sexo;
    }

    protected void setCpf(int cpf) throws Exception{
        if ((String.valueOf(cpf).length()) != 11) {
            throw new Exception("CPF INVALIDO");
        }
        this.cpf = cpf;
    }

    protected int getCpf() {
        return cpf;
    }

}
