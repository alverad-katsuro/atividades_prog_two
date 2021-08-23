package com.system;
import java.util.UUID;
import java.util.Scanner;

public class Contrato {
    private final UUID id = UUID.randomUUID();
    private final Setor setor;
    private Funcionario funcionario;

    public Contrato(Setor setor) throws Exception{
        this.setor = setor;
        setor.addContrato(getId());
    }
    
    protected UUID getId() {
        return id;
    }

    protected Setor getSetor() {
        return setor;
    }

    protected Funcionario addFuncionario(Scanner sc) throws Exception{
        Funcionario funcionario = new Funcionario(sc);
        addFuncionario(funcionario);
        return funcionario;
    }

    protected Funcionario getFuncionario() {
        return funcionario;
    }

    protected void addFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
        funcionario.setSetor(getSetor());
        getSetor().addFuncionario(funcionario);
        funcionario.setContrato(getId());
    }
}
