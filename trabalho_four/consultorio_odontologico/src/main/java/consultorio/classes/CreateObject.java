package consultorio.classes;

import java.util.Scanner;

public class CreateObject {
    private CreateObject(){}


    public static Cliente createCliente(Scanner sc){
        String endereco, nome, cpf, telefone, email, sexo, plano;
        int idade;
        System.out.println("----------------- Cadastro do Cliente -----------------");
        System.out.print("Digite o nome: ");
        nome = sc.nextLine();
        System.out.print("Digite o CPF: ");
        cpf = sc.nextLine();
        System.out.print("Digite o Telefone: ");
        telefone = sc.nextLine();
        System.out.print("Digite o Email: ");
        email = sc.nextLine();
        System.out.print("Digite a Idade: ");
        idade = Integer.parseInt(sc.nextLine());
        System.out.print("Digite o Sexo[masculino/feminino]: ");
        sexo = sc.nextLine();
        System.out.print("Digite o Plano: ");
        plano = sc.nextLine();
        System.out.println("Endereco formato -> 'rua, Nº xx, bairro, cidade, estado, país, complemento.'\nUse corretamente as virgulas ','");
        System.out.print("Digite o Endereco: ");
        endereco = sc.nextLine();
        System.out.println("----------------------------------");
        return (new Cliente(endereco, nome, cpf, telefone, email, sexo, idade, plano));
    }

    public static Odontologista createOdontologista(Scanner sc){
        String endereco, nome, cpf, telefone, email, sexo, crm;
        int idade;
        System.out.println("----------------- Cadastro do Odontologista -----------------");
        System.out.print("Digite o nome: ");
        nome = sc.nextLine();
        System.out.print("Digite o CRM: ");
        crm = sc.nextLine();
        System.out.print("Digite o CPF: ");
        cpf = sc.nextLine();
        System.out.print("Digite o Telefone: ");
        telefone = sc.nextLine();
        System.out.print("Digite o Email: ");
        email = sc.nextLine();
        System.out.print("Digite a Idade: ");
        idade = Integer.parseInt(sc.nextLine());
        System.out.print("Digite o Sexo[masculino/feminino]: ");
        sexo = sc.nextLine();
        System.out.println("Endereco formato -> 'rua, Nº xx, bairro, cidade, estado, país, complemento.'\nUse corretamente as virgulas ','");
        System.out.print("Digite o Endereco: ");
        endereco = sc.nextLine();
        System.out.println("----------------------------------");
        return (new Odontologista(endereco, nome, cpf, telefone, email, sexo, idade, crm));
    }

    
}
