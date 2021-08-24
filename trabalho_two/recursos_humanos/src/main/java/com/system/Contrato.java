package com.system;
import java.util.UUID;

public class Contrato {
    /* Observe que todos os atributos são imutaveis, uma vez que um contrato define o setor do funcionario */
    private final UUID id = UUID.randomUUID();
    private final Setor setor;
    private final Funcionario funcionario;

    /* Temos o construtor que ira definir o setor e adicionar a ID do contrato no mesmo */
    public Contrato(Setor setor, Funcionario funcionario) throws Exception{
        this.setor = setor;
        this.funcionario = funcionario;
        setor.addContrato(getId());
        addFuncionario(funcionario);
    }
    
    /* Aqui havera o cadastro do funcionario no contrato, observe que o contrato é para somente um funcionario */
    protected void addFuncionario(Funcionario funcionario) {
        funcionario.setSetor(getSetor());
        getSetor().addFuncionario(funcionario);
        funcionario.setContrato(getId());
    }

    /* Aqui temos o encapsulamento dos atributos */
    protected UUID getId() {
        return id;
    }

    protected Setor getSetor() {
        return setor;
    }

    protected Funcionario getFuncionario() {
        return funcionario;
    }
}
