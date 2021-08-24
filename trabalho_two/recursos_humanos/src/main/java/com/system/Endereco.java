package com.system;

import java.util.Scanner;
/* Está classe é responsavel por armazenar o endereço dos funcionarios */
public class Endereco {
    private String endereco[] = new String[4];

    /* Forma interativa do usuario informar os endereços dos funcionario */
    protected void defineEndereco(Scanner sc){
        System.out.printf("\033[1;34mDigite a rua:\033[1;97m ");
        setEnderecoRua(sc.nextLine());
        System.out.printf("\033[1;34mDigite a bairro:\033[1;97m ");
        setEnderecoBairro(sc.nextLine());
        System.out.printf("\033[1;34mDigite a cidade:\033[1;97m ");
        setEnderecoCidade(sc.nextLine());
        System.out.printf("\033[1;34mDigite a Estado:\033[1;97m ");
        setEnderecoEstado(sc.nextLine());
    }
    

    /* Abaixo a os metodos de encapsulamento */
    protected void setEndereco(String rua, String bairro, String cidade, String estado) {
        this.endereco[0] = rua;
        this.endereco[1] = bairro;
        this.endereco[2] = cidade;
        this.endereco[3] = estado;
    }

    protected String[] getEndereco() {
        return endereco;
    }

    protected void setEnderecoRua(String rua) {
        this.endereco[0] = rua;
    }

    protected void setEnderecoBairro(String bairro) {
        this.endereco[1] = bairro;
    }

    protected void setEnderecoCidade(String cidade) {
        this.endereco[2] = cidade;
    }

    protected void setEnderecoEstado(String estado) {
        this.endereco[3] = estado;
    }
}
