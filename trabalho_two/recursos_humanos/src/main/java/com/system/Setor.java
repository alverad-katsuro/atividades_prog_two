package com.system;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Scanner;

public enum Setor {
    REQUISITOS,
    MODELAGEM,
    CODIFICACAO,
    TESTE,
    RECURSOS_HUMANOS;

    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<UUID> contratos = new ArrayList<>();
    private Funcionario chefe;

    protected void setChefe(Funcionario chefe) {
        if (getChefe() == null) {
            this.chefe = chefe;
        } else{
            getChefe().setCargo(Cargo.COLABORADOR);
            this.chefe = chefe;
        }
    }

    protected void setChefe(Scanner sc) throws Exception {
        setChefe((new Funcionario(sc)));
        addFuncionario(getChefe());
    }

    protected Funcionario getChefe() {
        return this.chefe;
    }

    protected void addFuncionario(Funcionario funcionario) {
        getFuncionarios().add(funcionario);
    }

    protected Funcionario addFuncionario(Scanner sc) throws Exception {
        Funcionario funcionario = new Funcionario(sc);
        addFuncionario(funcionario);
        return funcionario;
    }

    void addContrato(UUID contrato) {
        getContratos().add(contrato);
    }
    
    public ArrayList<UUID> getContratos() {
        return contratos;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    protected boolean demitirFuncionario(Funcionario funcionario_demitido, Scanner sc) throws Exception{
        return is_boss_or_demit(funcionario_demitido, sc);
    }

    protected ArrayList<Funcionario> getColaboradores() {
        ArrayList<Funcionario> array_temp = new ArrayList<>();
        for (Funcionario funcionario : getFuncionarios()) {
            if (funcionario.getCargo() == Cargo.COLABORADOR) {
                array_temp.add(funcionario);
            }
        }
        return array_temp;
    }

    protected Funcionario buscaFuncionario(long cpf){
        for (Funcionario funcionario : getFuncionarios()) {
            if (funcionario.getCpf() == cpf) {
                return funcionario;
            }
        }
        return null;
    }

    protected Funcionario buscaFuncionario(String nome){
        for (Funcionario funcionario : getFuncionarios()) {
            if (funcionario.getNome() == nome) {
                return funcionario;
            }
        }
        return null;
    }

    private boolean removeFuncionario(Funcionario funcionario){
        for (int i = 0; i < getFuncionarios().size(); i++) {
            if (funcionario.getCpf() == getFuncionarios().get(i).getCpf()) {
                Funcionario.modify_Numero_de_funcionarios(-1);
                getFuncionarios().remove(i);
                return true;
            }
        }
        return false;
    }

    private boolean is_boss_or_demit(Funcionario funcionario_demitido, Scanner sc) throws Exception{
        if (funcionario_demitido.getCpf() == getChefe().getCpf()) {
            System.out.println(getFuncionarios().size());
            if (getFuncionarios().size() >= 2){
                System.out.printf("Digite o CPF do novo Chefe do Setor: ");
                Funcionario funcionario = buscaFuncionario(sc.nextLong());
                setChefe(funcionario);
                addFuncionario(funcionario);
            } else if (getFuncionarios().size() == 1) {
                System.out.println("Cadastro do novo chefe");
                Funcionario funcionario = addFuncionario(sc);
                setChefe(funcionario);
                addFuncionario(funcionario);
            }
        }
        removeFuncionario(funcionario_demitido);
        return removeFuncionario(funcionario_demitido);
    }

}
