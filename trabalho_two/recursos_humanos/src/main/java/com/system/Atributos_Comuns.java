package com.system;

public class Atributos_Comuns extends Endereco {
    private String nome;
    private String email;
    private long telefone;

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

    protected void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    protected long getTelefone() {
        return telefone;
    }
}
