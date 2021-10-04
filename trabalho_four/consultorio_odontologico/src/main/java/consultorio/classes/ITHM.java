package consultorio.classes;

import java.util.ArrayList;
import java.util.Scanner;

import consultorio.bd.AgendarConsulta;
import consultorio.bd.Atualizar_Dados;

public class ITHM {
    private ITHM(){}


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

    public static ArrayList<Cliente> buscaCliente(Scanner sc){
        String escolha[] = new String[2];
        System.out.println("----------------- Busca do Odontologista -----------------");
        System.out.print("Digite\n0. Exibir todos clientes\n: 1. Realizar busca Especifica\nResposta: ");
        escolha[0] = sc.nextLine();
        switch (escolha[0]) {
            case "0":
                return Atualizar_Dados.searchClient(escolha);     
            case "1":
                System.out.print("Digite o rotulo [idclient, nome, email, cpf, idade, plano, sexo, telefone]\nRotulo: ");
                escolha[0] = sc.nextLine();
                System.out.print("Digite uma correspondencia para o rotulo(ex: nome da pessoa) \nCorrespôndencia: ");
                escolha[1] = sc.nextLine();
                return Atualizar_Dados.searchClient(escolha);     
        }
        return null;
    }
    
    public static ArrayList<Odontologista> buscaOdontologista(Scanner sc){
        String escolha[] = new String[2];
        System.out.println("----------------- Busca do Odontologista -----------------");
        System.out.print("Digite\n0. Exibir todos Odontologista\n: 1. Realizar busca Especifica\nResposta: ");
        escolha[0] = sc.nextLine();
        switch (escolha[0]) {
            case "0":
                return Atualizar_Dados.searchDentista(escolha);     
            case "1":
                System.out.print("Digite o rotulo [iddentista, nome, email, cpf, idade, crm, sexo, telefone]\nRotulo: ");
                escolha[0] = sc.nextLine();
                System.out.print("Digite uma correspondencia para o rotulo(ex: nome da pessoa) \nCorrespôndencia: ");
                escolha[1] = sc.nextLine();
                return Atualizar_Dados.searchDentista(escolha);     
        }
        return null;
    }

    public static ArrayList<Consulta> consultarAgendamento(Scanner sc){
        String data[] = new String[2];
        System.out.println("----------------- Consulta Agendamento -----------------");
        System.out.print("Digite\n0. Realizar busca por periodo\n1. Buscar Agendamento Especifico\nResposta: ");
        data[0] = sc.nextLine();
        switch (data[0]) {
            case "0":
                return AgendarConsulta.searchConsulta(data);
            case "1":
                System.out.println("Formato da data 'xxxx-xx-xx' -> ano-mes-dia");
                System.out.print("Digite o inicio do intervalo\nResposta: ");
                data[0] = sc.nextLine();
                System.out.print("Digite o fim do intervalo\nResposta: ");
                data[1] = sc.nextLine();
                return AgendarConsulta.searchConsulta(data);
        }
        return null;
    }

    public void modificaCliente(Scanner sc){
        String option[] = new String[2];
        option[0] = "cpf";
        System.out.println("----------------- Modifica Cliente -----------------");
        System.out.print("Digite o CPF do cliente no formato -> 'xxx.xxx.xxx-xx'\nResposta: ");
        option[1] = sc.nextLine();
        Cliente cliente = Atualizar_Dados.searchClient(option).get(0);
        System.out.print("Digite o rotulo do dado a ser atualizado [nome, email, cpf, idade, plano, sexo, telefone]\nResposta: ");
        option[0] = sc.nextLine();
        System.out.print("Digite o novo valor do dado.\nResposta: ");
        option[1] = sc.nextLine();
        switch (option[0]) {
            case "nome":
                cliente.setNome(option[1]);
                break; 
            case "email":
                cliente.setEmail(option[1]);
                break; 
            case "cpf":
                cliente.setCpf(option[1]);
                break; 
            case "idade":
                cliente.setIdade(Integer.parseInt(option[1]));
                break; 
            case "plano":
                cliente.setPlano(option[1]);
                break; 
            case "sexo":
                cliente.setSexo(option[1]);
                break; 
            case "telefone":
                cliente.setTelefone(option[1]);
                break; 
        }
        Atualizar_Dados.modifyClient(cliente);
    }

    public void modificaOdontologista(Scanner sc){
        String option[] = new String[2];
        option[0] = "cpf";
        System.out.println("----------------- Modifica Odontologista -----------------");
        System.out.print("Digite o CPF do cliente no formato -> 'xxx.xxx.xxx-xx'\nResposta: ");
        option[1] = sc.nextLine();
        Odontologista odontologista = Atualizar_Dados.searchDentista(option).get(0);
        System.out.print("Digite o rotulo do dado a ser atualizado [nome, email, cpf, idade, crm, sexo, telefone]\nResposta: ");
        option[0] = sc.nextLine();
        System.out.print("Digite o novo valor do dado.\nResposta: ");
        option[1] = sc.nextLine();
        switch (option[0]) {
            case "nome":
                odontologista.setNome(option[1]);
                break; 
            case "email":
                odontologista.setEmail(option[1]);
                break; 
            case "cpf":
                odontologista.setCpf(option[1]);
                break; 
            case "idade":
                odontologista.setIdade(Integer.parseInt(option[1]));
                break; 
            case "crm":
                odontologista.setCRM(option[1]);
                break; 
            case "sexo":
                odontologista.setSexo(option[1]);
                break; 
            case "telefone":
                odontologista.setTelefone(option[1]);
                break; 
        }
        Atualizar_Dados.modifyDentista(odontologista);
    }
}
