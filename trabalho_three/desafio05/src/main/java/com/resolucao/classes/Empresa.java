package com.resolucao.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Empresa {
    // Array com os funcionarios da empresa
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private Areas area;

    public void setArea(Areas area) {
        this.area = area;
    }
    public Areas getArea() {
        return area;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void addFuncionarios(Funcionario funcionario) {
        getFuncionarios().add(funcionario);
    }

    /// Busca o maior e menor salario global e a media deles
    public void maiorMenorSalario(){
        ArrayList<Funcionario> max = new ArrayList<>();
        max.add(getFuncionarios().get(0));
        ArrayList<Funcionario> min = new ArrayList<>();
        min.add(getFuncionarios().get(0));
        double salario_tot = 0;
        for (Funcionario funcionario : getFuncionarios()) {
            if (funcionario.getSalario() > max.get(0).getSalario()) {
                max.clear();
                max.add(funcionario);
            } else if (funcionario.getSalario() == max.get(0).getSalario()){
                max.add(funcionario);
            }
            if (funcionario.getSalario() < min.get(0).getSalario()) {
                min.clear();
                min.add(funcionario);
            } else if (funcionario.getSalario() == min.get(0).getSalario()){
                min.add(funcionario);
            }
            salario_tot += funcionario.getSalario();
        }
        for (Funcionario funcionario : max) {
            System.out.printf("global_max|%s %s|%.2f%n", funcionario.getNome(), funcionario.getSobrenome(), funcionario.getSalario());
        }
        for (Funcionario funcionario : min) {
            System.out.printf("global_min|%s %s|%.2f%n", funcionario.getNome(), funcionario.getSobrenome(), funcionario.getSalario());
        }
        System.out.printf("global_avg|%.2f%n%n", salario_tot / getFuncionarios().size());
    }

    /// Busca o maior e menor salario de cada area e a media deles
    public void maiorMenorSalario_area(){
        for (int i = getArea().getAreas().size() - 1; i >= 0; i--) {
            ArrayList<Funcionario> max = new ArrayList<>();
            ArrayList<Funcionario> min = new ArrayList<>();
            double salario_tot = 0;
            for (Funcionario funcionario : getFuncionarios()) {
                if (funcionario.getArea() == getArea().getAreas().get(i)[1]) {
                    if (max.size() == 0 || funcionario.getSalario() > max.get(0).getSalario()) {
                        max.clear();
                        max.add(funcionario);
                    } else if (funcionario.getSalario() == max.get(0).getSalario()){
                        max.add(funcionario);
                    }
                    if (min.size() == 0 ||funcionario.getSalario() < min.get(0).getSalario()) {
                        min.clear();
                        min.add(funcionario);
                    } else if (funcionario.getSalario() == min.get(0).getSalario()){
                        min.add(funcionario);
                    }
                    salario_tot += funcionario.getSalario();
                }
            }
            Map<String, Integer> numero_pessoas_setor = conta_pessoas();
            String area = getArea().getAreas().get(i)[1];
            for (Funcionario funcionario : max) {
                System.out.printf("area_max|%s|%s %s|%.2f%n", funcionario.getArea(), funcionario.getNome(), funcionario.getSobrenome(), funcionario.getSalario());
            }
            for (Funcionario funcionario : min) {
                System.out.printf("area_min|%s|%s %s|%.2f%n", funcionario.getArea(), funcionario.getNome(), funcionario.getSobrenome(), funcionario.getSalario());
            }
            System.out.printf("area_avg|%s|%.2f%n%n", area ,salario_tot / numero_pessoas_setor.get(area));
        }
    }

    /// Descreve a area com maior e menor funcionario na empresa
    public void moreFunc(){
        Map<String, Integer> tabela = conta_pessoas();
        ArrayList<String> max = new ArrayList<>();
        ArrayList<String> min = new ArrayList<>();
        for (Map.Entry<String, Integer> hash : tabela.entrySet()) {
            if (max.size() == 0) {
                max.add(hash.getKey());
            } else if (hash.getValue() > tabela.get(max.get(0))) {
                max.clear();
                max.add(hash.getKey());
            } else if (hash.getValue() == tabela.get(max.get(0))){
                max.add(hash.getKey());
            }
            if (min.size() == 0) {
                min.add(hash.getKey());
            } else if (hash.getValue() < tabela.get(min.get(0))) {
                min.clear();
                min.add(hash.getKey());
            } else if (hash.getValue() == tabela.get(min.get(0))){
                min.add(hash.getKey());
            }
        }
        for (String area : max) {
            System.out.printf("most_employees|%s|%d%n", area, tabela.get(area));
        }
        for (String area : min) {
            System.out.printf("least_employees|%s|%d%n", area, tabela.get(area));
        }
    }

    public ArrayList<Funcionario> addFuncionariosHash(ArrayList<Funcionario> list_func, Funcionario funcionario){
        ArrayList<Funcionario> temp = new ArrayList<>();
        temp = list_func;
        temp.add(funcionario);
        return temp;
    }

    public ArrayList<Funcionario> addFuncionariosHash(Funcionario funcionario){
        ArrayList<Funcionario> temp = new ArrayList<>();
        temp.add(funcionario);
        return temp;
    }

    // Procura pessoas com sobrenome igual que recebe a mesma quantidade
    public void sobrenomeIgual(){
        Map<String, ArrayList<Funcionario>> tabela = new HashMap<>(); 
        for (Funcionario funcionario : getFuncionarios()) {
            if (!tabela.containsKey(funcionario.getSobrenome())) {
                tabela.put(funcionario.getSobrenome(), (addFuncionariosHash(funcionario)));
            } else if (tabela.get(funcionario.getSobrenome()).get(0).getSalario() == funcionario.getSalario()){
                tabela.put(funcionario.getSobrenome(), addFuncionariosHash(tabela.get(funcionario.getSobrenome()), funcionario));
            } else if (tabela.get(funcionario.getSobrenome()).get(0).getSalario() < funcionario.getSalario()){
                tabela.put(funcionario.getSobrenome(), (addFuncionariosHash(funcionario)));
            }
        }
        for (Map.Entry<String, ArrayList<Funcionario>> hash : tabela.entrySet()) {
            if (hash.getValue().size() > 1){
                for (Funcionario funcionario : hash.getValue()) {
                    System.out.printf("last_name_max|%s|%s %s|%.2f%n", funcionario.getSobrenome(),funcionario.getNome(), funcionario.getSobrenome(), funcionario.getSalario());
                }
            }
        }
    }

    // Simplificação
    private Map<String, Integer> conta_pessoas(){
        Map<String, Integer> tabela = new HashMap<String, Integer>();
        for (int i = 0; i < getArea().getAreas().size(); i++) {
            tabela.put(getArea().getAreas().get(i)[1], 0);
        }
        for (Funcionario funcionario : getFuncionarios()) {
            tabela.put(funcionario.getArea(), tabela.get(funcionario.getArea()) + 1);
        }
        return tabela;
    }
}
