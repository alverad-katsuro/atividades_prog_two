package com.system;

import java.util.ArrayList;
import java.util.Scanner;
/* Aqui a á definição da classe empresa, observe que ela herda os atributos comuns como nome, endereço e etc */
public class Empresa extends Atributos_Comuns {
    private String dono;
    private final long cnpj;
    private ArrayList<Contrato> contratos = new ArrayList<>();
    private final Setor[] setores = {Setor.REQUISITOS, Setor.MODELAGEM, Setor.CODIFICACAO, Setor.TESTE, Setor.RECURSOS_HUMANOS};
    
    /* Aqui há o contrutor da empresa, no qual define as informações vitais da mesma */
    public Empresa(String dono, String nome, String email, long telefone, long CNPJ) throws Exception{
        setDono(dono);
        this.cnpj = CNPJ;
        setNome(nome);
        setEmail(email);
        setTelefone(telefone);
    }

    /* Abaixo há o metodo para adicionar um novo contrato na empresa, isto é, um novo funcionario também */
    public Contrato addContrato(Scanner sc, Setor setor, Funcionario funcionario) throws Exception{
        Contrato temp = new Contrato(setor, funcionario);
        getContratos().add(temp);
        return temp;
    }
    
    /* Abaixo há os encapsulamentos */
    public long getCNPJ() {
        return cnpj;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public String getDono() {
        return dono;
    }

    public Setor[] getSetores() {
        return setores;
    }

    public ArrayList<Contrato> getContratos() {
        return contratos;
    }    
}
