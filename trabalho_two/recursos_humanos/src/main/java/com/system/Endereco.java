package com.system;

public class Endereco {
    private String endereco[] = new String[4];

    public Endereco(String rua, String bairro, String cidade, String estado){
        setEndereco(rua, bairro, cidade, estado);
    }

    public Endereco(){
        String temp = "A definir";
        setEndereco(temp, temp, temp, temp);
    }

    public String[] getEndereco() {
        return endereco;
    }

    public void setEndereco(String rua, String bairro, String cidade, String estado) {
        this.endereco[0] = rua;
        this.endereco[1] = bairro;
        this.endereco[2] = cidade;
        this.endereco[3] = estado;
    }

    public void setEnderecoRua(String rua) {
        this.endereco[0] = rua;
    }

    public void setEnderecoBairro(String bairro) {
        this.endereco[1] = bairro;
    }

    public void setEnderecoCidade(String cidade) {
        this.endereco[2] = cidade;
    }

    public void setEnderecoEstado(String estado) {
        this.endereco[3] = estado;
    }
    
}
