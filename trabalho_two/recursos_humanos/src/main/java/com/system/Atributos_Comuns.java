package com.system;
import java.util.Scanner;
/* Aqui vamos ter a classe com os atributos comuns entre a empresa e uma pessoa */
public class Atributos_Comuns extends Endereco {
    private String nome;
    private String email;
    private long telefone;

    /* Aqui vai ser definido o nome da pessoa, observe que há um output pro usuario */
    protected  void defineNome(Scanner sc) throws Exception {
        System.out.printf("\033[1;34mDigite o nome:\033[1;97m ");
        String nome = sc.nextLine();
        setNome(nome);
    }
    
    /* Aqui vai ser definido o email da pessoa, observe que há um output pro usuario */
    protected  void defineEmail(Scanner sc) throws Exception {
        System.out.printf("\033[1;34mDigite o email da pessoa:\033[1;97m ");
        String email = sc.nextLine();
        while (!email.contains("@")) {
            System.out.printf("\033[1;34mDigite o email da pessoa:\033[1;97m ");
            email = sc.nextLine();
        }
        setEmail(email);
    }
    
    /* Aqui vai ser definido o telefone da pessoa, observe que há um output pro usuario */
    protected  void defineTelefone(Scanner sc) throws Exception {
        System.out.printf("\033[1;34mDigite o telefone da pessoa com DD:\033[1;97m ");
        setTelefone(sc.nextLong());
        sc.nextLine();
    }

    /* Encapsulamento dos metodos */
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
