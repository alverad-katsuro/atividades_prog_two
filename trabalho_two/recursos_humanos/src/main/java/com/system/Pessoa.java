package com.system;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Pessoa extends Atributos_Comuns{
    private long cpf;
    private String sexo;
    private int idade;
    private int dia;
    private int mes;
    private int ano;

    /* Metodo para definir o CPF da pessoa interativamente */
    protected  void defineCPF(Scanner sc) throws Exception {
        System.out.printf("\033[1;34mDigite o CPF da pessoa:\033[1;97m ");
        setCpf(sc.nextLong());
        sc.nextLine();
    }

    /* Metodo para definir o sexo da pessoa interativamente */
    protected  void defineSexo(Scanner sc) throws Exception {
        System.out.printf("\033[1;34mDigite o sexo da pessoa\nM. Masculino\nF. Feminino\n Resposta:\033[1;97m ");
        String sexo = sc.nextLine();
        sexo = sexo.toUpperCase();
        setSexo(sexo);
    }

    /* Metodo para definir a data de nascimento da pessoa interativamente */
    protected  void defineDataNascimento(Scanner sc) throws Exception {
        System.out.printf("\033[1;34mDigite o dia de nascimento:\033[1;97m ");
        setDia(sc.nextInt());
        System.out.printf("\033[1;34mDigite o mes de nascimento:\033[1;97m ");
        setMes(sc.nextInt());
        System.out.printf("\033[1;34mDigite o ano de nascimento:\033[1;97m ");
        setAno(sc.nextInt());
        sc.nextLine();
        calculaIdade();
    }

    /* Metodo responsavel por calcular a idade da pessoa a partir da data de nascimento */
    public void calculaIdade() {
        int dia, mes, ano;
        SimpleDateFormat format_year = new SimpleDateFormat("yyyy");
        SimpleDateFormat format_mouth = new SimpleDateFormat("MM");
        SimpleDateFormat format_day = new SimpleDateFormat("dd");
        Date date = new Date(System.currentTimeMillis());
        ano = Integer.parseInt(format_year.format(date).toString());
        mes = Integer.parseInt(format_mouth.format(date).toString());
        dia = Integer.parseInt(format_day.format(date).toString());
        if (getMes() < mes) {
            setIdade((ano - getAno()));
            //System.out.printf("A idade do %s é %d anos%n", getNome(), getIdade());
        } else if (mes == getMes()) {
            if (dia >= getDia()){
                setIdade((short)(ano - getAno()));
                //System.out.printf("A idade do %s é %d anos%n", getNome(), getIdade());
            }
        } else if (mes > getMes()) {
            setIdade((short) (ano - getAno() - 1));
            //System.out.printf("A idade do %s é %d anos%n", getNome(), getIdade());
        }
    }

    /* Metodos de encapsulamento abaixo --> autoexplicativo */

    private void setDia(int dia) throws Exception {
        if (dia < 0 || dia > 31) {
            throw new Exception("\033[1;91mDia invalido");
        }
        this.dia = dia;
    }

    protected int getDia() {
        return dia;
    }

    private void setMes(int mes) throws Exception{
        if (mes < 0 || mes > 12) {
            throw new Exception("\033[1;91mMes invalido");
        }
        this.mes = mes;
    }

    protected int getMes() {
        return mes;
    }

    private void setAno(int ano) throws Exception{
        Calendar calendario = Calendar.getInstance();
        if (ano < 0 || ano > calendario.get(Calendar.YEAR)) {
            throw new Exception("\033[1;91mANO INVALIDO");
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

    private void setSexo(String sexo) throws Exception{
        if (sexo.equals("M") || sexo.equals("F")){
            this.sexo = sexo;
        } else {
            throw new Exception("\033[1;91mSEXO INVALIDO");
        }
    }

    protected String getSexo(){
        return this.sexo;
    }

    private void setCpf(long cpf){
        this.cpf = cpf;
    }

    protected long getCpf() {
        return cpf;
    }

}
