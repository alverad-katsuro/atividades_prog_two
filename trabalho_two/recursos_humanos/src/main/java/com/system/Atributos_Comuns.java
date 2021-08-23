package com.system;
import java.util.Scanner;

public class Atributos_Comuns extends Endereco {
    private String nome;
    private String email;
    private long telefone;

    protected  void defineNome(Scanner sc) throws Exception {
        System.out.printf("\033[1;34mDigite o nome da pessoa:\033[1;97m ");
        String nome = sc.nextLine();
        setNome(nome);
    }

    protected  void defineEmail(Scanner sc) throws Exception {
        System.out.printf("\033[1;34mDigite o email da pessoa:\033[1;97m ");
        String email = sc.nextLine();
        while (!email.contains("@")) {
            System.out.printf("\033[1;34mDigite o email da pessoa:\033[1;97m ");
            email = sc.nextLine();
        }
        setEmail(email);
    }

    protected  void defineTelefone(Scanner sc) throws Exception {
        System.out.printf("\033[1;34mDigite o telefone da pessoa com DD:\033[1;97m ");
        setTelefone(sc.nextLong());
        sc.nextLine();
    }

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

    protected void setTelefone(long telefone){
        this.telefone = telefone;
    }

    protected long getTelefone() {
        return telefone;
    }
}
