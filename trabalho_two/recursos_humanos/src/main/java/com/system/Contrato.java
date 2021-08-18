package com.system;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Scanner;

public class Contrato {
    private final UUID id = UUID.randomUUID();
    private final Setor setor;
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public Contrato(Setor setor){
        this.setor = setor;
    }
    
    protected UUID getId() {
        return id;
    }

    protected void getChefe(){
        this.setor.getChefe();
    }

    protected Setor getSetor() {
        return setor;
    }

    protected void addFuncionario(Funcionario funcionario){
        funcionario.setSetor(getSetor());
        getSetor().addFuncionario(funcionario);
        getSetor().addContrato(getId());
        this.funcionarios.add(funcionario);
    }

    protected boolean removeFuncionario(Funcionario funcionario){
        for (int i = 0; i < getFuncionarios().size(); i++) {
            if (funcionario.getCpf() == getFuncionarios().get(i).getCpf()) {
                getFuncionarios().remove(i);
                return true;
            }
        }
        return false;
    }

    protected ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
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

    protected Funcionario buscaFuncionario(int cpf){
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

    protected boolean demitirFuncionario(int cpf){
        Funcionario funcionario_demitido = buscaFuncionario(cpf);
        if (funcionario_demitido == null) {
            return false;
        }
        is_boss_or_demit(funcionario_demitido);
        return true;
    }

    protected boolean demitirFuncionario(String nome){
        Funcionario funcionario_demitido = buscaFuncionario(nome);
        if (funcionario_demitido == null) {
            return false;
        }
        is_boss_or_demit(funcionario_demitido);

        return true;
    }

    private void is_boss_or_demit(Funcionario funcionario_demitido){
        if (funcionario_demitido.getCpf() == getSetor().getChefe().getCpf()) {
            Scanner sc = new Scanner(System.in);
            System.out.printf("Digite o CPF do novo Chefe do Setor: ");
            getSetor().setChefe(buscaFuncionario(sc.nextInt()));
        }
        getSetor().removeFuncionario(funcionario_demitido);
        removeFuncionario(funcionario_demitido);
    }
}
