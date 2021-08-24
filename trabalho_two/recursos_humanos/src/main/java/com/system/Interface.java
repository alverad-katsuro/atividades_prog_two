package com.system;

import java.time.LocalDate;
import java.util.Scanner;

public class Interface {
    private Empresa empresa;

    public Interface(Scanner sc) throws Exception{
        Empresa empresa = new Empresa("Reginaldo Santos", "RHTec", "rhtec@rhtec.com", 91912345678l, 12345678912345l);
        setEmpresa(empresa);
    }

    /* Metodo não utilizado --> serve para reaproveitar codigo/cadastrar a empresa interativamente */
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
    }

    /* Metodo que ira definir as ferias --> acessivel pelo menu */
    protected void setFerias(Scanner sc) throws Exception{
        Funcionario funcionario = buscaOneFuncionario(sc);
        funcionario.setFerias(sc);
    }

    /* Metodo que ira retornar as informações pertinentes dos setores --> acessivel pelo menu */
    public void informacoesSetor(){
        double custo = 0;
        int contador = 0;
        for (Contrato contrato : getEmpresa().getContratos()) {
            custo += contrato.getFuncionario().getSalario();
            contador += 1;
        }
        for (Setor setor : getEmpresa().getSetores()) {
            if (setor.getChefe() == null) {
                System.out.printf("O Setor: %s não possui chefe, contratos e colaboradores %n", setor.toString());
            } else{
                System.out.printf("O Setor: %s tem %s como chefe e possui %d contratos e %d colaboradores com média salarial %.2f e custo %.2f %n", setor.toString(), setor.getChefe().getNome(), setor.getContratos().size(), setor.getFuncionarios().size() - 1, custo/contador, custo);
            }
        }
    }

    /* Metodo que ira retornar as informações pertinentes da empresa --> acessivel pelo menu */
    public void informacoesEmpresa(){
        System.out.printf("\033[1;34m%25s%n", "INFORMAÇÔES DA EMPRESA");
        System.out.printf("Dono:                            \033[1;97m%s%n", getEmpresa().getDono());
        System.out.printf("Nome:                            \033[1;97m%s%n", getEmpresa().getNome());
        System.out.printf("CNPJ:                            \033[1;97m%014d%n", getEmpresa().getCNPJ());
        System.out.printf("Email:                           \033[1;97m%s%n", getEmpresa().getEmail());
        System.out.printf("Telefone:                        \033[1;97m%d%n", getEmpresa().getTelefone());
        System.out.printf("Numeros de FUncionarios:         \033[1;97m%d%n", getEmpresa().getContratos().size());
        System.out.println();
    }

    /* Metodo que ira definir atualizar os dados dos funcionarios --> acessivel pelo menu */
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
            case ("FERIAS"):{
                funcionario.setFerias(sc);
            }
        }
    }
 
    /* Metodo que ira buscar um funcionario e apresenta-lo na tela --> acessivel pelo menu */
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

    /* Metodo que ira buscar um funcionario ou varios funcionarios e apresenta-lo na tela --> acessivel pelo menu */
    public void buscarFuncionario(Scanner sc) throws Exception{
        int escolha = escolhe_modo_busca(sc);
        switch (escolha) {
            case 0:
                System.out.printf("\033[1;34mDigite a matricula do funcionario:\033[1;97m ");
                getFuncionario(sc.nextLine(), 5);
            case 1:
                System.out.printf("\033[1;34mDigite o nome do funcionario:\033[1;97m ");
                getFuncionario(sc.nextLine());
                break;
            case 2:
                System.out.printf("\033[1;34mDigite o CPF do funcionario:\033[1;97m ");
                getFuncionario(sc.nextLong());
                break;
            case 3:
                System.out.printf("\033[1;34mDigite\n1. Masculino\n2. Feminino\nEscolha:\033[1;97m ");
                int temp = sc.nextInt();
                sc.nextLine();
                getFuncionarios(temp);
                break;
            case 4:
                System.out.printf("\033[1;34mDigite o Estado de busca:\033[1;97m ");
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

    /* Metodo que ira admitir um funcionario --> acessivel pelo menu */
    public void admitirFuncionario(Scanner sc) throws Exception{
        Setor escolha = escolhe_setor(sc);
        switch (escolha) {
            case REQUISITOS:
                modulo_admitir(escolha, sc);
                break;
            case MODELAGEM:
                modulo_admitir(escolha, sc);
                break;
            case CODIFICACAO:
                modulo_admitir(escolha, sc);
                break;
            case TESTE:
                modulo_admitir(escolha, sc);
                break;
            case RECURSOS_HUMANOS:
                modulo_admitir(escolha, sc);
                break;
        }
    }

    /* Metodo que ira demitir um funcionario e apresenta-lo na tela --> acessivel pelo menu */
    public void demitirFuncionario(Scanner sc) throws Exception{
        Funcionario funcionario = buscaOneFuncionario(sc);
        if (demiteFuncionarioModulo(funcionario, sc)) {
            System.out.println("\033[1;92mFuncionario Demitido!");
        } else{
            System.out.println("\033[1;91mFuncionario não encontrado!");
        }
    }

    /* Continuação do demitir funcionario --> usado para evitar repetir codigo */
    private void modulo_admitir(Setor setor, Scanner sc) throws Exception{
        Funcionario funcionario;
        if (setor.getChefe() == null) {
            funcionario = new Funcionario(sc, Cargo.CHEFE);
            setor.setChefe(funcionario);
        } else{
            funcionario = new Funcionario(sc);
        }
        getEmpresa().addContrato(sc, setor, funcionario);
    }

    /* Metodos usados para as diversas formas de busca */
    /* ################## INICIO ###################### */
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
        Funcionario max_min[] = new Funcionario[2];
        Boolean teste = true;
        for (Setor setor : getEmpresa().getSetores()) {
            for (Funcionario funcionario : setor.getFuncionarios()) {
                if (teste) {
                    max_min[0] = funcionario;
                    max_min[1] = funcionario;
                    teste = false;
                }
                if (funcionario.getSalario() > max_min[0].getSalario()) {
                    max_min[0] = funcionario;
                }
                if (funcionario.getSalario() < max_min[1].getSalario()) {
                    max_min[1] = funcionario;
                }
            }
        }
        System.out.println("Maior Salario");
        formatoutput(max_min[0], max_min[0].getSetor());
        System.out.println("Menor Salario");
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
        int contador = 0;
        double salario_med = 0;
        for (Setor setor : getEmpresa().getSetores()) {
            for (Funcionario funcionario : setor.getFuncionarios()) {
                if (funcionario.getSexo().equals(sexo_string)) {
                    formatoutput(funcionario, setor);
                    contador += 1;
                    salario_med += funcionario.getSalario();
                }
            }
        }
        if (sexo_string == "M") {
            System.out.printf("A %d homens na empresa com media salárial de: %.2f%n", contador, salario_med/contador);
        } else {   
            System.out.printf("A %d mulheres na empresa com media salárial de: %.2f%n", contador, salario_med/contador);
        }
    }

    private void getFuncionarios(Setor setor){
        int contador = 0;
        double salario_med = 0;
        System.out.printf("\nO setor %s tem %d funcionarios\n", setor.toString(), setor.getFuncionarios().size());
        for (Funcionario funcionario : setor.getFuncionarios()) {
            formatoutput(funcionario, setor);
            contador += 1;
            salario_med += funcionario.getSalario();
        }
        System.out.printf("\nA média salarial do setor é: %.2f%n", salario_med/contador);
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

    /*############################ FIM ############################ */

    /* Modulo usado ao demitir funcionario --> esta evitando repetição tambem */
    private Boolean demiteFuncionarioModulo(Funcionario funcionario, Scanner sc) throws Exception{
        for (Setor setor : getEmpresa().getSetores()) {
            if (setor.getFuncionarios().size() > 0 && setor.demitirFuncionario(funcionario, sc)) {
                return true;
            }
        }
        return false;
    }

    /* Modulo usadopara escolher a forma de encontrar o funcionario --> opção disponivel no menu */
    private int escolhe_modo_busca(Scanner sc) {
        int escolha;
        System.out.printf("\033[1;34mDigite\n0. Busca por Matricula\n1. Busca por Nome\n2. Busca por CPF\n3. Busca por Sexo\n4. Busca por Estado\n5. Busca por Setor\n6. Maior e Menor Salario\n7. Listar Todos\nEscolha:\033[1;97m ");
        escolha = sc.nextInt();
        sc.nextLine();
        return escolha;
    }

    /* Modulo usadopara escolher a forma de encontrar o funcionario --> opção disponivel no menu */
    private int escolhe_modo_busca_one(Scanner sc) {
        int escolha;
        System.out.printf("\033[1;34mDigite\n0. Busca por Matricula\n1. Busca por Nome\n2. Busca por CPF\nEscolha:\033[1;97m ");
        escolha = sc.nextInt();
        sc.nextLine();
        return escolha;
    }

    /* Modulo usadopara escolher a forma de encontrar o funcionario --> opção disponivel no menu */
    private Setor escolhe_setor(Scanner sc) {
        int escolha;
        System.out.printf("\033[1;34mDigite\n1.Setor de Requisitos\n2.Setor de Modelagem\n3.Setor de Codificação\n4.Setor de Testes\n5.Recursos Humanos\nEscolha:\033[1;97m ");
        escolha = sc.nextInt();
        sc.nextLine();
        return getEmpresa().getSetores()[escolha - 1];
    }

    /* ENCAPSULAMENTO DA EMPRESA --> como é uma empresa fixa definimos ela como atributo da INTERFACE */
    private void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    private Empresa getEmpresa() {
        return empresa;
    }

    /* OUTPUT --> define o formato da exibição dos funcionarios */
    private void formatoutput(Funcionario funcionario, Setor setor){
        if (funcionario.getContrato() == null) {
            formatoutput_modulo(funcionario);
        } else{
            formatoutput_modulo(funcionario);
            System.out.printf("\033[1;34mContrato:          \033[1;97m%s%n", funcionario.getContrato().toString());
            System.out.println();
        }
    }

    /* (SIMPLIFICAÇÂO/EVITAR REPETIÇÂO) OUTPUT --> define o formato da exibição dos funcionarios */
    private void formatoutput_modulo(Funcionario funcionario){
        System.out.println();
        System.out.printf("\033[1;34m%25s%n", "INFORMAÇÔES");
        System.out.printf("\033[1;34mNome:              \033[1;97m%s%n", funcionario.getNome());
        System.out.printf("\033[1;34mTelefone:          \033[1;97m%011d%n", funcionario.getTelefone());
        System.out.printf("\033[1;34mCPF:               \033[1;97m%011d%n", funcionario.getCpf());
        System.out.printf("\033[1;34mIdade:             \033[1;97m%d%n", funcionario.getIdade());
        System.out.printf("\033[1;34mMatricula:         \033[1;97m%s%n", funcionario.getMatricula().toString());
        System.out.printf("\033[1;34mSetor:             \033[1;97m%s%n", funcionario.getSetor().toString());
        System.out.printf("\033[1;34mCargo:             \033[1;97m%s%n", funcionario.getCargo().toString());
        System.out.printf("\033[1;34mSalario:           \033[1;97m%.2f%n", funcionario.getSalario());
        System.out.printf("\033[1;34mEndereço:          \033[1;97mRua %s, %s, %s, %s%n", funcionario.getEndereco()[0], funcionario.getEndereco()[1], funcionario.getEndereco()[2], funcionario.getEndereco()[3]);
        if (funcionario.getFerias()[0] != null) {
            if (LocalDate.now().isBefore(funcionario.getFerias()[0])) {
                System.out.printf("\033[1;34mFerias em:         \033[1;97m%s ate %s%n", funcionario.getFerias()[0].toString(), funcionario.getFerias()[1].toString());
                
            } else if (LocalDate.now().isAfter(funcionario.getFerias()[0]) && LocalDate.now().isBefore(funcionario.getFerias()[1])) {   
                System.out.printf("\033[1;34mFerias:            \033[1;97maté %s%n", funcionario.getFerias()[1]);
            } else {
                System.out.printf("\033[1;34mFerias:            \033[1;97maté %s%n", "Sem Férias Cadastrada para este ano");
            }
            
        } else {
            System.out.printf("\033[1;34mFerias:            \033[1;97m%s%n", "Sem Férias Cadastrada");
        }
        System.out.printf("\033[1;34mData de Ingresso:  \033[1;97m%s%n", funcionario.getData_de_ingresso());
    }

}
