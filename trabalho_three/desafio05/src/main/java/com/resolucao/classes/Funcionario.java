package com.resolucao.classes;

public class Funcionario {
    private int id;
    private String nome;
    private String sobrenome;
    private float salario;
    private String area;


    @Override
    public String toString() {
        return "Funcionario [area=" + area + ", id=" + id + ", nome=" + nome + " " + sobrenome +", salario=" + salario + "]\n";
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public float getSalario() {
        return salario;
    }
    public void setSalario(float salario) {
        this.salario = salario;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }

    
}
