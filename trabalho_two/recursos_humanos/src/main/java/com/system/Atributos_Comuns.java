package com.system;
import java.util.Scanner;

public class Atributos_Comuns extends Endereco {
    private String nome;
    private String email;
    private long telefone;

    protected  void defineNome(Scanner sc) throws Exception {
        sc.nextLine();
        System.out.printf("Digite o nome da pessoa: ");
        String nome = sc.nextLine();
        setNome(nome);
    }

    protected  void defineEmail(Scanner sc) throws Exception {
        sc.nextLine();
        System.out.printf("Digite o email da pessoa: ");
        String email = sc.nextLine();
        while (!email.contains("@")) {
            System.out.printf("Digite o email da pessoa: ");
            email = sc.nextLine();
        }
        setEmail(email);
    }

    protected  void defineTelefone(Scanner sc) throws Exception {
        System.out.printf("Digite o telefone da pessoa com DD: ");
        setTelefone(sc.nextLong());
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
