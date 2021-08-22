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
        getSetor().addContrato(getId());
        this.funcionarios.add(funcionario);
    }

    protected void addFuncionario(Scanner sc) throws Exception{
        Funcionario funcionario = new Funcionario(sc);
        this.funcionarios.add(funcionario);
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

    protected boolean demitirFuncionario(long cpf){
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

    private void is_boss_or_demit(Funcionario funcionario_demitido){
        if (funcionario_demitido.getCpf() == getSetor().getChefe().getCpf()) {
            Scanner sc = new Scanner(System.in);
            System.out.printf("Digite o CPF do novo Chefe do Setor: ");
            getSetor().setChefe(buscaFuncionario(sc.nextInt()));
            sc.close();
        }
        getSetor().removeFuncionario(funcionario_demitido);
        removeFuncionario(funcionario_demitido);
    }
}
