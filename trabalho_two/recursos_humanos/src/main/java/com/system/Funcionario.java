package com.system;

/* Responsavel pelo Input */
import java.util.Scanner;
/* Gerador de ID's */
import java.util.UUID;
/* Bibliotecas para manipular datas */
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/* Observe que o funcionario é uma pessoa, logo ele herda todos seus atributos */
public class Funcionario extends Pessoa {
    private Cargo cargo = Cargo.COLABORADOR;
    private float salario;
    private Setor setor;
    private UUID contrato;
    private LocalDate ferias[] = new LocalDate[2];
    private final Date data_de_ingresso = new Date(System.currentTimeMillis());
    private final float salario_minimo = 1127.0f;
    private final UUID matricula = UUID.randomUUID();
    private static int numero_de_funcionarios = 0;

    /* Construtor */
    public Funcionario(Scanner sc) throws Exception{
        simplificaConstrutor(sc);
    }
    
    /* Construtor */
    public Funcionario(Scanner sc, Cargo cargo) throws Exception{
        setCargo(cargo);
        simplificaConstrutor(sc);
    }

    /* Modulo usado nos dois construtores --> feito para evitar repetição */
    private void simplificaConstrutor(Scanner sc) throws Exception{
        defineNome(sc);
        defineCPF(sc);
        defineSexo(sc);
        defineDataNascimento(sc);
        defineEmail(sc);
        defineEndereco(sc);
        defineSalario(sc);
        defineTelefone(sc);
        modify_Numero_de_funcionarios(1);
        System.out.printf("\033[1;34mFuncionario: \033[1;97m%s \033[1;34mCargo: \033[1;97m%s \033[1;34mMatricula ID: \033[1;97m%s%n%n",getNome(), getCargo().toString(), getMatricula().toString());
    }

    /* Definição interativa das ferias do funcionario */
    protected void setFerias(Scanner sc) throws Exception{
        System.out.println("Entre com a data do seu nascimento: (dd/mm/yyyy) ");
        String str = sc.nextLine();
        System.out.printf("Entre com a quantidade de dias de ferias: ");
        int dias = sc.nextInt(); 
        sc.nextLine();
        setFerias(str, dias);
    }

    /* Definição interativa do salario do funcionario */
    protected void defineSalario(Scanner sc) throws Exception{
        System.out.printf("\033[1;34mDigite o salario do funcionario:\033[1;97m ");
        float salario = sc.nextFloat();
        while (salario < getSalario_minimo()) {
            System.out.printf("\033[1;34mDigite o salario do funcionario:\033[1;97m ");
            salario = sc.nextFloat();
        }
        setSalario(salario);
    }

    /* Abaixo há os metodos de encapsulamento */
    protected UUID getMatricula() {
        return matricula;
    }

    protected Date getData_de_ingresso() {
        return data_de_ingresso;
    }
    
    protected Cargo getCargo() {
        return cargo;
    }

    protected void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
    protected UUID getContrato() {
        return contrato;
    }

    protected void setContrato(UUID contrato) {
        this.contrato = contrato;
    }

    public float getSalario_minimo() {
        return salario_minimo;
    }

    protected float getSalario() {
        return salario;
    }

    private void setSalario(float salario) throws Exception {
        if (salario < salario_minimo) {
            throw new Exception("\033[1;91mSALARIO INFERIOR AO SALARIO MINIMO");
        }
        this.salario = salario;
    }

    public LocalDate[] getFerias() {
        return ferias;
    }

    protected Setor getSetor() {
        return setor;
    }

    protected void setSetor(Setor setor) {
        this.setor = setor;
    }

    public static int getNumero_de_funcionarios() {
        return numero_de_funcionarios;
    }

    private void setFerias(String data_str, int dias_de_ferias) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(data_str, fmt);
        this.ferias[0] = data;
        this.ferias[1] = data.plusDays(dias_de_ferias);
    }

    /* Este metodo serve para modificar o contador de funcionarios da empresa */
    private static void modify_Numero_de_funcionarios(int number) {
        Funcionario.numero_de_funcionarios += number;
    }
}
