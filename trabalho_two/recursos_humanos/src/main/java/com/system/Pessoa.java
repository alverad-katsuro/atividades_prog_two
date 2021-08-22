package com.system;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Pessoa extends Atributos_Comuns{
    private long cpf;
    private char sexo;
    private int idade;
    private int dia;
    private int mes;
    private int ano;

    protected  void defineCPF(Scanner sc) throws Exception {
        System.out.printf("Digite o cpf da pessoa: ");
        setCpf(sc.nextLong());
    }

    protected  void defineSexo(Scanner sc) throws Exception {
        System.out.printf("Digite o sexo da pessoa\nM. Masculino\nF. Feminino\n Resposta: ");
        setSexo(sc.next().charAt(0));
    }

    protected  void defineDataNascimento(Scanner sc) throws Exception {
        System.out.printf("Digite o dia de nascimento: ");
        setDia(sc.nextInt());
        System.out.printf("Digite o mes de nascimento: ");
        setMes(sc.nextInt());
        System.out.printf("Digite o ano de nascimento: ");
        setAno(sc.nextInt());
        calculaIdade();
    }

    public void calculaIdade() {
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

    private void setDia(int dia) throws Exception {
        if (dia < 0 || dia > 31) {
            throw new Exception("Dia invalido");
        }
        this.dia = dia;
    }

    protected int getDia() {
        return dia;
    }

    private void setMes(int mes) throws Exception{
        if (mes < 0 || mes > 12) {
            throw new Exception("Mes invalido");
        }
        this.mes = mes;
    }

    protected int getMes() {
        return mes;
    }

    private void setAno(int ano) throws Exception{
        if (ano < 0 || ano > 2021) {
            throw new Exception("Ano invalido");
        }
        this.ano = ano;
    }

    protected int getAno() {
        return ano;
    }

    private void setIdade(int idade) {
        this.idade = idade;
    }

    protected int getIdade() {
        return idade;
    }

    private void setSexo(char sexo) throws Exception{
        if (sexo == 'M' || sexo == 'm'  || sexo == 'F' || sexo == 'f'){
            this.sexo = sexo;
        } else {
            throw new Exception("SEXO INVALIDO");
        }
    }

    protected char getSexo(){
        return this.sexo;
    }

    private void setCpf(long cpf) throws Exception{
        if ((String.valueOf(cpf).length()) != 11) {
            throw new Exception("CPF INVALIDO");
        }
        this.cpf = cpf;
    }

    protected long getCpf() {
        return cpf;
    }

}
