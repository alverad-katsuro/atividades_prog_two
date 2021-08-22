package com.system;

import java.util.Scanner;

public class Endereco {
    private String endereco[] = new String[4];

    
    protected String[] getEndereco() {
        return endereco;
    }

    protected void setEndereco(String rua, String bairro, String cidade, String estado) {
        this.endereco[0] = rua;
        this.endereco[1] = bairro;
        this.endereco[2] = cidade;
        this.endereco[3] = estado;
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
    
    protected void definirEndereco(Scanner sc){
        System.out.printf("Digite a rua: ");
        setEnderecoRua(sc.nextLine());
        System.out.printf("Digite a bairro: ");
        setEnderecoBairro(sc.nextLine());
        System.out.printf("Digite a cidade: ");
        setEnderecoCidade(sc.nextLine());
        System.out.printf("Digite a Estado: ");
        setEnderecoEstado(sc.nextLine());
    }
}
