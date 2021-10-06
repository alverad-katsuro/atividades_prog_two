package consultorio.classes;

import java.util.ArrayList;
import java.util.Scanner;

import consultorio.bd.AgendarConsulta;
import consultorio.bd.Atualizar_Dados;

public class ITHM {
    private ITHM(){}


    public static boolean createCliente(Scanner sc){
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
        return Atualizar_Dados.insertCliente(new Cliente(endereco, nome, cpf, telefone, email, sexo, idade, plano));
    }

    public static boolean createOdontologista(Scanner sc){
        String endereco, nome, cpf, telefone, email, sexo, crm, especializacao;
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
        System.out.print("Digite a especializacao [PROTETICO, DENTISTA, CIRURGIAO]: ");
        especializacao = sc.nextLine();
        System.out.println("Endereco formato -> 'rua, Nº xx, bairro, cidade, estado, país, complemento.'\nUse corretamente as virgulas ','");
        System.out.print("Digite o Endereco: ");
        endereco = sc.nextLine();
        System.out.println("----------------------------------");
        return Atualizar_Dados.insertDentista(new Odontologista(endereco, nome, cpf, telefone, email, sexo, idade, crm, especializacao));
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
        System.out.print("Digite\n0. Listar todos Agendamentos\n1. Realizar busca por periodo\n2. Buscar Agendamento Especifico\nResposta: ");
        data[0] = sc.nextLine();
        switch (data[0]) {
            case "0":
                return AgendarConsulta.searchConsulta(data);
            case "1":
                System.out.println("Formato da data 'xxxx-xx-xx xx:xx' -> ano-mes-dia hora:minuto");
                System.out.print("Digite o inicio do intervalo\nResposta: ");
                data[0] = sc.nextLine();
                System.out.print("Digite o fim do intervalo\nResposta: ");
                data[1] = sc.nextLine();
                return AgendarConsulta.searchConsulta(data);
            case "2":
                System.out.print("Digite a IdConsulta\nResposta: ");
                data[1] = sc.nextLine();
                data[0] = "IdConsulta";
                return AgendarConsulta.searchConsulta(data);
        }
        return null;
    }

    public static boolean modificaConsulta(Scanner sc){
        String id[] = new String[2];
        id[0] = "IdConsulta";
        System.out.println("----------------- Modifica Consulta -----------------");
        System.out.print("Digite a IdConsulta\nResposta: ");
        id[1] = sc.nextLine();
        Consulta consulta = AgendarConsulta.searchConsulta(id).get(0);
        System.out.print("Digite o rotulo do que deseja modificar [especializacao, crm_dentista, cpf_cliente, data, valor, realizada, notas]\nResposta: ");
        id[0] = sc.nextLine();
        System.out.print("Digite o novo valor do rotulo\nResposta: ");
        id[1] = sc.nextLine();
        switch (id[0]) {
            case "especializacao":
                consulta.setEspecializacao(Consulta.comparadorEspecialidade(id[1]));
                break; 
            case "crm_dentista":
                consulta.setCrm_dentista(id[1]);
                break; 
            case "cpf_cliente":
                consulta.setCpf_cliente(id[1]);
                break; 
            case "data":
                consulta.setData(id[1]);
                break; 
            case "valor":
                consulta.setValor(Float.parseFloat(id[1]));
                break; 
            case "realizada":
                consulta.setRealizada(Consulta.comparadorStatus(id[1]));
                break; 
            case "notas":
                consulta.setNotas(id[1]);
                break; 
        }
        AgendarConsulta.modifyConsulta(consulta);
        return true;
    }

    public static void modificaCliente(Scanner sc){
        String option[] = new String[2];
        option[0] = "cpf";
        System.out.println("----------------- Modifica Cliente -----------------");
        System.out.print("Digite o CPF do cliente no formato -> 'xxx.xxx.xxx-xx'\nResposta: ");
        option[1] = "'"+sc.nextLine()+"'";
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
                cliente.setSexo(Pessoa.comparaSexo(option[1]));
                break; 
            case "telefone":
                cliente.setTelefone(option[1]);
                break; 
        }
        Atualizar_Dados.modifyClient(cliente);
    }

    public static void modificaOdontologista(Scanner sc){
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
                odontologista.setCrm(option[1]);
                break; 
            case "sexo":
                odontologista.setSexo(Pessoa.comparaSexo(option[1]));
                break; 
            case "telefone":
                odontologista.setTelefone(option[1]);
                break; 
        }
        Atualizar_Dados.modifyDentista(odontologista);
    }

    public static boolean createConsulta(Scanner sc){
        String especializacao, crm_dentista, cpf_cliente, data;
        float valor;
        System.out.println("----------------- Agendamento de Consulta -----------------");
        System.out.print("Digite a especialização: ");
        especializacao = sc.nextLine().toUpperCase();
        System.out.print("Digite o CRM: ");
        crm_dentista = sc.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        cpf_cliente = sc.nextLine();
        System.out.print("Digite a Data -> 'ano-mes-dia xx:xx': ");
        data = sc.nextLine();
        System.out.print("Digite o Valor da consulta: ");
        valor = Float.parseFloat(sc.nextLine());
        System.out.println("----------------------------------");
        String teste_c[] = {"cpf", cpf_cliente};
        String teste_d[] = {"Crm", crm_dentista};
        if (Atualizar_Dados.searchClient(teste_c).size() > 0 && Atualizar_Dados.searchDentista(teste_d).size() > 0) {
            return AgendarConsulta.agendarConsulta(new Consulta(especializacao, crm_dentista, cpf_cliente, data, valor, "PENDENTE"));
        }
        return false;
    }
}
