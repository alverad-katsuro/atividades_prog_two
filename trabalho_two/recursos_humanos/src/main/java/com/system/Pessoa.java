package com.system;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Pessoa extends Atributos_Comuns{
    private long cpf;
    private String sexo;
    private LocalDate data_nascimento;
    private int idade;

    /* Metodo para definir a data de nascimento da pessoa interativamente */
    protected void defineDataNascimento(Scanner sc) {
        System.out.printf("\033[1;34mEntre com a data de nascimento:\033[1;97m ");
        String data_nascimento_string = sc.nextLine();; 
        setData_nascimento(data_nascimento_string);
        calculateAge(getData_nascimento(), LocalDate.now());
    }

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

    /* Metodo responsavel por calcular a idade da pessoa a partir da data de nascimento */
    private int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            int idade = Period.between(birthDate, currentDate).getYears();
            setIdade(idade);
            return idade;
        } else {
            return 0;
        }
    }

    /* Metodos de encapsulamento abaixo --> autoexplicativo */

    protected void setData_nascimento(String data_nascimento) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(data_nascimento, fmt);
        this.data_nascimento = data;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    protected int getDia() {
        return getData_nascimento().getDayOfMonth();
    }

    protected int getMes() {
        return getData_nascimento().getMonthValue();
    }


    protected int getAno() {
        return getData_nascimento().getYear();
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
