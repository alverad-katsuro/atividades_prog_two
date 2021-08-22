package com.system;

import java.util.ArrayList;
import java.util.Scanner;

public class Empresa extends Atributos_Comuns {
    private String dono;
    private final long cnpj;
    private ArrayList<Contrato> contratos = new ArrayList<>();
    private final Setor[] setores = {Setor.CODIFICACAO, Setor.MODELAGEM, Setor.RECURSOS_HUMANOS, Setor.REQUISITOS, Setor.TESTE};
    
    public Empresa(String dono, String nome, String email, long telefone, long CNPJ) throws Exception{
        setDono(dono);
        if ((String.valueOf(CNPJ).length()) != 14) {
            throw new Exception("CNPJ INVALIDO");
        }
        this.cnpj = CNPJ;
        setNome(nome);
        setEmail(email);
        setTelefone(telefone);
    }
    
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

    public void addContrato(Scanner sc, Setor setor) throws Exception{
        getContratos().add(new Contrato(setor, sc));
    }
}
