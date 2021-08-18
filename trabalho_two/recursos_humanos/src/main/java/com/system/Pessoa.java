package com.system;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Pessoa extends Atributos_Comuns{
    private int cpf;
    private boolean sexo;
    private short idade;
    private byte dia;
    private byte mes;
    private short ano;

    public Pessoa(String nome, byte dia, byte mes, short ano) {
        setNome(nome);
        setAno(ano);
        setDia(dia);
        setMes(mes);
    }

    public void calculaIdade_auto() {
        SimpleDateFormat format_year = new SimpleDateFormat("yyyy");
        SimpleDateFormat format_mouth = new SimpleDateFormat("MM");
        SimpleDateFormat format_day = new SimpleDateFormat("dd");
        Date date = new Date(System.currentTimeMillis());
        System.out.printf("A idade atual é %d anos %d meses e %d dias %n", (format_year.format(date)), (format_mouth.format(date)), (format_day.format(date)));
    }

    public void calculaIdade() {
        Byte dia, mes;
        Short ano;
        Scanner sc = new Scanner(System.in);
        System.out.printf("Digite o dia: ");
        dia = sc.nextByte();
        System.out.printf("Digite o mes: ");
        mes = sc.nextByte();
        System.out.printf("Digite o ano: ");
        ano = sc.nextShort();
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
        sc.close();
    }

    public  void ajustaDataDeNascimento() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Digite o dia de nascimento: ");
        setDia(sc.nextByte());
        System.out.printf("Digite o mes de nascimento: ");
        setMes(sc.nextByte());
        System.out.printf("Digite o ano de nascimento: ");
        setAno(sc.nextShort());
        sc.close();
        
    }

    public void setAno(short ano) {
        this.ano = ano;
    }

    public short getAno() {
        return ano;
    }

    public void setDia(byte dia) {
        this.dia = dia;
    }

    public byte getDia() {
        return dia;
    }

    public void setIdade(short idade) {
        this.idade = idade;
    }

    public short getIdade() {
        return idade;
    }

    public void setMes(byte mes) {
        this.mes = mes;
    }

    public byte getMes() {
        return mes;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public boolean getSexo(){
        return this.sexo;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getCpf() {
        return cpf;
    }

}
