package com.system;

public class Atributos_Comuns extends Endereco {
    private String nome;
    private String email;
    private int telefone;

    protected void setEmail(String email) {
        this.email = email;
    }

    protected String getEmail() {
        return email;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected String getNome() {
        return nome;
    }

    protected void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    protected int getTelefone() {
        return telefone;
    }
}
