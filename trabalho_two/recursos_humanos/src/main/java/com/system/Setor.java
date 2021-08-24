package com.system;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Scanner;
    
/* Definição do Enum Setor com todos os setores da empresa */
public enum Setor {
    REQUISITOS,
    MODELAGEM,
    CODIFICACAO,
    TESTE,
    RECURSOS_HUMANOS;

    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<UUID> contratos = new ArrayList<>();
    private Funcionario chefe;

    /* Metodo responsavel por retornar os colaboradores, o chefe não está incluido */
    protected ArrayList<Funcionario> getColaboradores() {
        ArrayList<Funcionario> array_temp = new ArrayList<>();
        for (Funcionario funcionario : getFuncionarios()) {
            if (funcionario.getCargo() == Cargo.COLABORADOR) {
                array_temp.add(funcionario);
            }
        }
        return array_temp;
    }

    /* Metodo responsavel por busca algum funcionario do setor a partir do cpf */
    protected Funcionario buscaFuncionario(long cpf){
        for (Funcionario funcionario : getFuncionarios()) {
            if (funcionario.getCpf() == cpf) {
                return funcionario;
            }
        }
        return null;
    }

    /* Metodo responsavel por busca algum funcionario do setor a partir do nome */
    protected Funcionario buscaFuncionario(String nome){
        for (Funcionario funcionario : getFuncionarios()) {
            if (funcionario.getNome() == nome) {
                return funcionario;
            }
        }
        return null;
    }

    /* Metodo responsavel por demitir um funcionario, observe que se for demitir o chefe é necessario definir um novo */
    protected boolean demitirFuncionario(Funcionario funcionario_demitido, Scanner sc) throws Exception{
        return is_boss_or_demit(funcionario_demitido, sc);
    }

    /* Segunda parte do metodo acima, verifica se o funcionario é chefe ou não e demite o mesmo */
    private boolean is_boss_or_demit(Funcionario funcionario_demitido, Scanner sc) throws Exception{
        if (funcionario_demitido.getCpf() == getChefe().getCpf()) {
            System.out.println(getFuncionarios().size());
            if (getFuncionarios().size() >= 2){
                for (Funcionario funcionario : getColaboradores()) {
                    System.out.printf("Nome: %s CPF: %d%n", funcionario.getNome(), funcionario.getCpf());
                }
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
        return removeFuncionario(funcionario_demitido);
    }

    /* Metodo responsavel por remover o funcionario do setor */
    private boolean removeFuncionario(Funcionario funcionario_in){
        for (Funcionario funcionario : getFuncionarios()) {
            if (funcionario_in.getCpf() == funcionario.getCpf()) {
                getContratos().remove(funcionario.getMatricula());
                getFuncionarios().remove(funcionario);
                return true;
            }
        }
        return false;
    }

    /* Metodos de Encapsulamento */
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

}
