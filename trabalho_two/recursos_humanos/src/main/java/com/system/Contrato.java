package com.system;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Scanner;

public class Contrato {
    private final UUID id = UUID.randomUUID();
    private final Setor setor;
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public Contrato(Setor setor, Scanner sc) throws Exception{
        this.setor = setor;
        setor.addContrato(getId());
        if (getSetor().getFuncionarios().size() > 0) {
            System.out.printf("Digite\n1. Adicionar funcionario existente\n2. Contratar funcionario\nEscolha: ");
            switch (sc.nextInt()) {
                case 1:
                    while (true) {
                        System.out.printf("Digite o cpf do funcionario: ");
                        Funcionario funcionario = buscaFuncionario(sc.nextLong());
                        if (funcionario != null) {
                            addFuncionario(funcionario);
                            break;
                        } else{
                            System.out.println("Funcionario não encontrado");
                        }    
                    }
                    break;
                default:
                    addFuncionario(sc);
                    break;
            }
        }
    }
    
    protected UUID getId() {
        return id;
    }

    protected Funcionario getChefe(){
        return this.setor.getChefe();
    }

    protected Setor getSetor() {
        return setor;
    }

    protected void addFuncionario(Funcionario funcionario){
        funcionario.setSetor(getSetor());
        getSetor().addFuncionario(funcionario);
        funcionario.setContrato(getId());
        getFuncionarios().add(funcionario);
    }

    protected Funcionario addFuncionario(Scanner sc) throws Exception{
        Funcionario funcionario = new Funcionario(sc);
        getFuncionarios().add(funcionario);
        return funcionario;
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

    protected boolean demitirFuncionario(Funcionario funcionario_demitido, Scanner sc) throws Exception{
        return is_boss_or_demit(funcionario_demitido, sc);
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
        if (funcionario_demitido.getCpf() == getSetor().getChefe().getCpf()) {
            System.out.println(getSetor().getFuncionarios().size());
            if (getSetor().getFuncionarios().size() >= 2){
                System.out.printf("Digite o CPF do novo Chefe do Setor: ");
                Funcionario funcionario = buscaFuncionario(sc.nextLong());
                getSetor().setChefe(funcionario);
                addFuncionario(funcionario);
            } else if (getSetor().getFuncionarios().size() == 1) {
                System.out.println("Cadastro do novo chefe");
                Funcionario funcionario = addFuncionario(sc);
                getSetor().setChefe(funcionario);
                addFuncionario(funcionario);
            }
        }
        getSetor().removeFuncionario(funcionario_demitido);
        return removeFuncionario(funcionario_demitido);
    }
}
