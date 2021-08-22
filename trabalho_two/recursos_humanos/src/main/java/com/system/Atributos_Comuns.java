package com.system;
import java.util.Scanner;

public class Atributos_Comuns extends Endereco {
    private String nome;
    private String email;
    private long telefone;

    protected  void defineNome(Scanner sc) throws Exception {
        System.out.printf("Digite o nome da pessoa: ");
        setNome(sc.nextLine());
    }

    protected  void defineEmail(Scanner sc) throws Exception {
        System.out.printf("Digite o email da pessoa: ");
        setEmail(sc.nextLine());
    }

    protected  void defineTelefone(Scanner sc) throws Exception {
        System.out.printf("Digite o telefone da pessoa: ");
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

    protected void setTelefone(long telefone) throws Exception {
        if ((String.valueOf(telefone).length()) != 11) {
            throw new Exception("TELEFONE INVALIDO");
        }
        this.telefone = telefone;
    }

    protected long getTelefone() {
        return telefone;
    }
}
