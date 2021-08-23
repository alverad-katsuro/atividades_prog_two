package com.system;

import java.util.Scanner;
import java.util.UUID;


public class Interface {
    private Empresa empresa;

    public Interface(Scanner sc) throws Exception{
        Empresa empresa = new Empresa("Reginaldo Santos", "RHTec", "rhtec@rhtec.com", 91912345678l, 12345678912345l);
        setEmpresa(empresa);
        cadastraChefe(sc);
    }

    public void cria_empresa(Scanner sc) throws Exception{
        String nome, email, dono;
        long CNPJ, telefone;
        System.out.println("--------------------------------------");
        System.out.println("CADASTRO DA EMPRESA");
        System.out.println("--------------------------------------");
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
        System.out.println("--------------------------------------");
        Empresa empresa = new Empresa(dono, nome, email, telefone, CNPJ);
        setEmpresa(empresa);
        sc.nextLine();
        cadastraChefeObrigatorio(sc);
    }

    public void informacoesSetor(){
        for (Setor setor : getEmpresa().getSetores()) {
            System.out.printf("O Setor: %s tem %s como chefe, %d contratos e %d funcionarios %n", setor.toString(), setor.getChefe().getNome(), setor.getContratos().size(), setor.getFuncionarios().size() - 1);
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
                break;
            }
            case ("IDADE"): {
                funcionario.defineDataNascimento(sc);
                break;
            }
            case ("CARGO"):{
                System.out.printf("Digite\n1. Chefe\n2. Colaborador\nResposta: ");
                int resposta = sc.nextInt();
                if (resposta == 1) {
                    funcionario.setCargo(Cargo.CHEFE);
                } else if (resposta == 2){
                    funcionario.setCargo(Cargo.COLABORADOR);
                } else{
                    System.out.println("Invalida");
                }
                sc.nextLine();
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
        int escolha = escolhe_modo_busca_one(sc);
        switch (escolha) {
            case 0:
                System.out.printf("Digite a matricula do funcionario: ");
                return getFuncionario(sc.nextLine(), 5);
            case 1:
                System.out.printf("Digite o nome do funcionario: ");
                return getFuncionario(sc.nextLine());
            case 2:
                System.out.printf("Digite o CPF do funcionario: ");
                long cpf = sc.nextLong();
                sc.nextLine();
                return getFuncionario(cpf);
            default:
                return null;
        }
    }

    public void buscarFuncionario(Scanner sc) throws Exception{
        int escolha = escolhe_modo_busca(sc);
        switch (escolha) {
            case 0:
                System.out.printf("Digite a matricula do funcionario: ");
                getFuncionario(sc.nextLine(), 5);
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

    public void showContratos(){
        for (Setor setor : getEmpresa().getSetores()) {
            for (UUID id : setor.getContratos()) {
                System.out.printf("Setor: %s Contrato: %s%n", setor.toString(), id.toString());
            }
        }
    }

    public void addFuncionario_in_contrato(Scanner sc, Funcionario funcionario) throws Exception{
        showContratos();
        System.out.print("Digite o contrato desejado: ");
        Contrato contrato = returnContratos(sc.nextLine());
        while (contrato == null) {
            System.out.print("Digite o contrato desejado: ");
            contrato = returnContratos(sc.nextLine());
        }
        contrato.addFuncionario(funcionario);
        funcionario.setContrato(contrato.getId());
    }

    public void admitirFuncionario(Scanner sc) throws Exception{
        Funcionario funcionario = new Funcionario(sc);
        Setor escolha = escolhe_setor(sc);
        switch (escolha) {
            case REQUISITOS:
                modulo_admitir(escolha, funcionario, sc);
                break;
            case MODELAGEM:
                modulo_admitir(escolha, funcionario, sc);
                break;
            case CODIFICACAO:
                modulo_admitir(escolha, funcionario, sc);
                break;
            case TESTE:
                modulo_admitir(escolha, funcionario, sc);
                break;
            case RECURSOS_HUMANOS:
                modulo_admitir(escolha, funcionario, sc);
                break;
        }
    }

    public void demitirFuncionario(Scanner sc) throws Exception{
        Funcionario funcionario = buscaOneFuncionario(sc);
        if (demiteFuncionarioModulo(funcionario, sc)) {
            System.out.println("Funcionario Demitido!");
        } else{
            System.out.println("Funcionario não encontrado!");
        }
    }

    private void modulo_admitir(Setor setor, Funcionario funcionario, Scanner sc) throws Exception{
        if (setor.getContratos().size() == 0) {
            Contrato contrato = getEmpresa().addContrato(sc, setor);
            contrato.addFuncionario(funcionario);
            funcionario.setContrato(contrato.getId());
            funcionario.setCargo(Cargo.CHEFE);
            setor.setChefe(funcionario);
        } else{
            addFuncionario_in_contrato(sc, funcionario);
        }
    }

    private Contrato returnContratos(String contrato){
        for (Contrato contrato_get : getEmpresa().getContratos()) {
            if (contrato_get.getId().toString().equals(contrato)) {
                return contrato_get;
            }
        }
        return null;
    }

    private void cadastraChefeObrigatorio(Scanner sc) throws Exception{
        System.out.println("Cadastro dos Chefes dos Setores");
        for (Setor setor : getEmpresa().getSetores()) {
            System.out.println("Cadastro do Chefe do Setor: " + setor.toString());
            setor.setChefe(sc);
        }
    }

    private Funcionario getFuncionario(String nome){
        for (Setor setor : getEmpresa().getSetores()) {
            for (Funcionario funcionario : setor.getFuncionarios()) {
                if (funcionario.getNome().equals(nome)) {
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
                if (funcionario.getMatricula().toString().equals(matricula)) {
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
        String sexo_string;
        if (sexo == 1) {
            sexo_string = "M";
        } else {
            sexo_string = "F";
        }
        for (Setor setor : getEmpresa().getSetores()) {
            for (Funcionario funcionario : setor.getFuncionarios()) {
                if (funcionario.getSexo().equals(sexo_string)) {
                    formatoutput(funcionario, setor);
                }
            }
        }
    }

    private void getFuncionarios(Setor setor){
        System.out.printf("\nO setor %s tem %d funcionarios\n", setor.toString(), setor.getFuncionarios().size());
            for (Funcionario funcionario : setor.getFuncionarios()) {
                formatoutput(funcionario, setor);
            }
    }

    private void getFuncionarios(String estado){
        for (Setor setor : getEmpresa().getSetores()) {
            for (Funcionario funcionario : setor.getFuncionarios()) {
                if (funcionario.getEndereco()[3].equals(estado)) {
                    formatoutput(funcionario, setor);
                }
            }
        }
    }

    private Boolean demiteFuncionarioModulo(Funcionario funcionario, Scanner sc) throws Exception{
        for (Contrato contrato : getEmpresa().getContratos()) {
            if (contrato.demitirFuncionario(funcionario, sc)) {
                return true;
            }
        }
        return false;
    }

    private int escolhe_modo_busca(Scanner sc) {
        int escolha;
        System.out.printf("Digite\n0. Busca por Matricula\n1. Busca por Nome\n2. Busca por CPF\n3. Busca por Sexo\n4. Busca por Estado\n5. Busca por Setor\n6. Maior e Menor Salario\n7. Listar Todos\nEscolha: ");
        escolha = sc.nextInt();
        sc.nextLine();
        return escolha;
    }

    private int escolhe_modo_busca_one(Scanner sc) {
        int escolha;
        System.out.printf("Digite\n0. Busca por Matricula\n1. Busca por Nome\n2. Busca por CPF\nEscolha: ");
        escolha = sc.nextInt();
        sc.nextLine();
        return escolha;
    }

    private Setor escolhe_setor(Scanner sc) {
        int escolha;
        System.out.printf("Digite\n1.Setor de Requisitos\n2.Setor de Modelagem\n3.Setor de Codificação\n4.Setor de Testes\n5.Recursos Humanos\nEscolha: ");
        escolha = sc.nextInt();
        sc.nextLine();
        return getEmpresa().getSetores()[escolha - 1];
    }

    private void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    private Empresa getEmpresa() {
        return empresa;
    }

    private void formatoutput(Funcionario funcionario, Setor setor){
        if (funcionario.getContrato() == null) {
            System.out.printf("Nome: %s Numero: %d Setor: %s CPF: %011d Cargo: %s Salario: %.2f Data de Ingresso: %s Matricula: %s%n", funcionario.getNome(), funcionario.getTelefone(), setor, funcionario.getCpf(), funcionario.getCargo().toString(),funcionario.getSalario(), funcionario.getData_de_ingresso().toString(), funcionario.getMatricula().toString());
        } else{
            System.out.printf("Nome: %s Numero: %d Setor: %s CPF: %011d Cargo: %s Salario: %.2f Contrato: %s Data de Ingresso: %s Matricula: %s%n", funcionario.getNome(), funcionario.getTelefone(), setor, funcionario.getCpf(), funcionario.getCargo().toString(),funcionario.getSalario(), funcionario.getContrato().toString(), funcionario.getData_de_ingresso().toString(), funcionario.getMatricula().toString());

        }
    }

}
