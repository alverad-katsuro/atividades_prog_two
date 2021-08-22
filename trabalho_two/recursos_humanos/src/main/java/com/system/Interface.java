package com.system;

import java.util.Scanner;

public class Interface {
    private Empresa empresa;

    public Interface(Scanner sc) throws Exception{
        cria_empresa(sc);
    }

    public void cria_empresa(Scanner sc) throws Exception{
        String nome, email, dono;
        long CNPJ, telefone;
        System.out.printf("Digite o nome do Dono da Empresa: ");
        dono = sc.nextLine();
        System.out.printf("Digite o nome da Empresa: ");
        nome = sc.nextLine();
        System.out.printf("Digite o email da Empresa: ");
        email = sc.nextLine();
        System.out.printf("Digite o telefone da Empresa: ");
        telefone = sc.nextLong();
        System.out.printf("Digite o CNPJ da Empresa: ");
        CNPJ = sc.nextLong();
        Empresa empresa = new Empresa(dono, nome, email, telefone, CNPJ);
        setEmpresa(empresa);
        cadastraChefeObrigatorio(sc);
    }

    public void informacoesSetor(Scanner sc){
        for (Setor setor : getEmpresa().getSetores()) {
            System.out.printf("O %s tem %s como chefe, %d contratos e %d funcionarios", setor.toString(), setor.getChefe(), setor.getContratos().size(), setor.getFuncionarios().size());
        }
    }

    public void atualizarFuncionario(Scanner sc) throws Exception{
        Funcionario funcionario = buscaOneFuncionario(sc);
        while (true) {
            if (funcionario != null) {
                break;
            }
        }
        System.out.print("DIGITE O ATRIBUTO QUE VOCE QUER MODIFICAR: ");
        String mod_att = sc.nextLine();
        switch (mod_att) {
            case ("NOME"): {
                funcionario.defineNome(sc);
            }
            case ("ENDERECO"): {
                funcionario.defineEndereco(sc);
                break;
            }
            case ("SEXO"): {
                funcionario.defineSexo(sc);
                break;
            }
            case ("CPF"): {
                funcionario.defineCPF(sc);
                break;
            }
            case ("EMAIL"): {
                funcionario.defineEmail(sc);
                break;
            }
            case ("TELEFONE"): {
                System.out.print("INSERIR TELEFONE: ");
                long change_telefone = sc.nextLong();
                funcionario.setTelefone(change_telefone);
                break;
            }
            case ("SALARIO"): {
                funcionario.defineSalario(sc);
                break;
            }
        }
    }

    public void novoContrato(Scanner sc) throws Exception{
        Setor setor = escolhe_setor(sc);
        getEmpresa().addContrato(sc, setor);
    }
  
    public void cadastraChefe(Scanner sc) throws Exception{
        Setor escolha = escolhe_setor(sc);
        escolha.setChefe(sc);
    }

    private Funcionario buscaOneFuncionario(Scanner sc) throws Exception{
        int escolha = escolhe_modo_busca(sc);
        switch (escolha) {
            case 0:
               System.out.printf("Digite a matricula do funcionario: ");
                return getFuncionario(sc.nextLine(), 5);
            case 1:
                System.out.printf("Digite o nome do funcionario: ");
                return getFuncionario(sc.nextLine());
            case 2:
                System.out.printf("Digite o CPF do funcionario: ");
                return getFuncionario(sc.nextLong());
        }
        return null;
    }

    public void buscarFuncionario(Scanner sc) throws Exception{
        int escolha = escolhe_modo_busca(sc);
        switch (escolha) {
            case 1:
                System.out.printf("Digite o nome do funcionario: ");
                getFuncionario(sc.nextLine());
                break;
            case 2:
                System.out.printf("Digite o CPF do funcionario: ");
                getFuncionario(sc.nextLong());
                break;
            case 3:
                System.out.printf("Digite\n1. Masculino\n2. Feminino\nEscolha: ");
                int temp = sc.nextInt();
                if (temp == 1){
                    getFuncionarios(1);
                } else if (temp == 2){
                    getFuncionarios(2);
                }
                break;
            case 4:
                System.out.printf("Digite o Estado de busca: ");
                getFuncionarios(sc.nextLine());
                break;
            case 5:
                Setor setor = escolhe_setor(sc);
                getFuncionarios(setor);
                break;
            case 6:
                getFuncionario_min_max_sal();
                break;
            case 7:
                getFuncionarios();
                break;
        }
    }

    public void admitirFuncionario(Scanner sc) throws Exception{
        Funcionario funcionario = new Funcionario(sc);
        Setor escolha = escolhe_setor(sc);
        switch (escolha) {
            case REQUISITOS:
                escolha.addFuncionario(funcionario);
                break;
            case MODELAGEM:
                escolha.addFuncionario(funcionario);
                break;
            case CODIFICACAO:
                escolha.addFuncionario(funcionario);
                break;
            case TESTE:
                escolha.addFuncionario(funcionario);
                break;
            case RECURSOS_HUMANOS:
                escolha.addFuncionario(funcionario);
                break;
        }
    }

    public void demitirFuncionario(Scanner sc) throws Exception{
        int forma_de_demitir;
        System.out.printf("Digite\n1. Entrar com CPF\n2. Entrar com Nome\nEscolha: ");
        forma_de_demitir = sc.nextInt();
        switch (forma_de_demitir) {
            case 1:
                System.out.printf("Digite o CPF: ");
                if (demiteFuncionarioModulo(sc.nextLong())) {
                    System.out.println("Funcionario Demitido!");
                } else{
                    System.out.println("Funcionario não encontrado!");
                }
                break;
            case 2:
                System.out.printf("Digite o Nome: ");
                if (demiteFuncionarioModulo(sc.nextLine())) {
                    System.out.println("Funcionario Demitido!");
                } else{
                    System.out.println("Funcionario não encontrado!");
                }
                break;
        }
    }

    private void cadastraChefeObrigatorio(Scanner sc) throws Exception{
        System.out.println("Cadastro dos Chefes dos Setores");
        for (Setor setor : getEmpresa().getSetores()) {
            System.out.printf("Cadastro do Chefe do Setor: %s%n", setor.toString());
            setor.setChefe(sc);
        }
    }

    private Funcionario getFuncionario(String nome){
        for (Setor setor : getEmpresa().getSetores()) {
            for (Funcionario funcionario : setor.getFuncionarios()) {
                if (funcionario.getNome() == nome) {
                    formatoutput(funcionario, setor);
                    return funcionario;
                }
            }
        }
        return null;
    }

    private Funcionario getFuncionario(String matricula, int teste){
        for (Setor setor : getEmpresa().getSetores()) {
            for (Funcionario funcionario : setor.getFuncionarios()) {
                if (funcionario.getMatricula().toString() == matricula) {
                    formatoutput(funcionario, setor);
                    return funcionario;
                }
            }
        }
        return null;
    }

    private void getFuncionario_min_max_sal(){
        Funcionario max_min[] = {getEmpresa().getSetores()[0].getChefe(), getEmpresa().getSetores()[0].getChefe()};
        for (Setor setor : getEmpresa().getSetores()) {
            for (Funcionario funcionario : setor.getFuncionarios()) {
                if (funcionario.getSalario() > max_min[0].getSalario()) {
                    max_min[0] = funcionario;
                }
                if (funcionario.getSalario() < max_min[1].getSalario()) {
                    max_min[1] = funcionario;
                }
            }
        }
        formatoutput(max_min[0], max_min[0].getSetor());
        formatoutput(max_min[1], max_min[1].getSetor());
    }

    private Funcionario getFuncionario(long cpf){
        for (Setor setor : getEmpresa().getSetores()) {
            for (Funcionario funcionario : setor.getFuncionarios()) {
                if (funcionario.getCpf() == cpf) {
                    formatoutput(funcionario, setor);
                    return funcionario;
                }
            }
        }
        return null;
    }

    private void getFuncionarios(){
        for (Setor setor : getEmpresa().getSetores()) {
            System.out.printf("\nO setor %s tem %d funcionarios\n", setor.toString(), setor.getFuncionarios().size());
            for (Funcionario funcionario : setor.getFuncionarios()) {
                formatoutput(funcionario, setor);
            }
        }
    }

    private void getFuncionarios(int sexo){
        for (Setor setor : getEmpresa().getSetores()) {
            for (Funcionario funcionario : setor.getFuncionarios()) {
                if (funcionario.getSexo() == sexo) {
                    formatoutput(funcionario, setor);
                }
            }
        }
    }

    private void getFuncionarios(Setor setor){
        System.out.printf("\nO setor %s tem %d funcionarios\n", setor.toString(), setor.getFuncionarios().size());
        for (Setor setor_list : getEmpresa().getSetores()) {
            if (setor == setor_list) {
                for (Funcionario funcionario : setor.getFuncionarios()) {
                    formatoutput(funcionario, setor);
                }
            }
        }
    }

    private void getFuncionarios(String estado){
        for (Setor setor : getEmpresa().getSetores()) {
            for (Funcionario funcionario : setor.getFuncionarios()) {
                if (funcionario.getEndereco()[3] == estado) {
                    formatoutput(funcionario, setor);
                }
            }
        }
    }

    private Boolean demiteFuncionarioModulo(long cpf){
        for (Contrato contrato : getEmpresa().getContratos()) {
            if (contrato.demitirFuncionario(cpf)) {
                return true;
            }
        }
        return false;
    }

    private Boolean demiteFuncionarioModulo(String nome){
        for (Contrato contrato : getEmpresa().getContratos()) {
            if (contrato.demitirFuncionario(nome)) {
                return true;
            }
        }
        return false;
    }

    private int escolhe_modo_busca(Scanner sc) {
        int escolha;
        System.out.printf("Digite\n0. Busca por Matricula\n1. Busca por Nome\n2. Busca por CPF\n3. Busca por Sexo\n4. Busca por Estado\n5. Busca por Setor\n6. Maior e Menor Salario\n7. Listar Todos\nEscolha: ");
        escolha = sc.nextInt();
        return escolha;
    }

    private Setor escolhe_setor(Scanner sc) {
        int escolha;
        System.out.printf("Digite\n1.Setor de Requisitos\n2.Setor de Modelagem\n3.Setor de Codificação\n4.Setor de Testes\n5.Recursos Humanos\nEscolha: ");
        escolha = sc.nextInt();
        return getEmpresa().getSetores()[escolha - 1];
    }

    private void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    private Empresa getEmpresa() {
        return empresa;
    }

    private void formatoutput(Funcionario funcionario, Setor setor){
        System.out.printf("Nome: %s Setor: %s CPF: %d Cargo: %s Salario: %.f Contrato: %s Data de Ingresso: %s Matricula: %s%n", funcionario.getNome(), setor, funcionario.getCpf(), funcionario.getCargo().toString(),funcionario.getSalario(), funcionario.getContrato(), funcionario.getData_de_ingresso().toString(), funcionario.getMatricula().toString());
    }

}