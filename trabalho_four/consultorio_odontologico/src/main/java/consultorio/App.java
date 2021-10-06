package consultorio;

import consultorio.classes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        String userPass[] = new String[2];
        System.out.print("Digite seu usuario: ");
        userPass[0] = sc.nextLine();
        System.out.print("Digite sua senha: ");
        userPass[1] = sc.nextLine();
        Contas contas = new Contas(userPass[0], userPass[1]);
        switch (contas.getFuncao()) {
            case ATENDENTE:
            atendente(sc);
            break;
            case DENTISTA:
            dentista(sc);
            break;
        }
        */
        atendente(sc);
        sc.close();
    }

    public static void atendente(Scanner sc){
        boolean cont = true;
        String escolhas;
        while (cont) {
            System.out.println("--------- Bem Vindo a OdontoLab ---------");
            System.out.print("Digite\n0. Cadastro\n1. Agendamento\n2. Consultas\n3. Relatorio\n4. Sair\nResposta:");
            escolhas = sc.nextLine();
            switch (escolhas) {
                case "0":
                menuCadastro(sc);
                break;
                case "1":
                menuAgendamento(sc);
                break;
                case "2":
                menuConsultas(sc);
                break;
                case "3":
                menuRelatorio(sc);
                break;
                case "4":
                cont = false;
                break;
            }
        }
    }

    public static void dentista(Scanner sc){
        boolean cont = true;
        String escolhas;
        while (cont) {
            System.out.println("--------- Bem Vindo a OdontoLab ---------");
            System.out.println("Digite\n0. Consultas\n1. Relatorio\n2. Sair\nResposta:");
            escolhas = sc.nextLine();
            switch (escolhas) {
                case "0":
                menuConsultas(sc);
                break;
                case "1":
                menuRelatorio(sc);
                break;
                case "2":
                cont = false;
                break;
            }
        }
    }

    public static void menuCadastro(Scanner sc){
        String escolha;
        System.out.println("Digite\n0. Cadastro Cliente\n1. Cadastro Odontologista\n2. Modificar Cliente\n3. Modificar Odontologista\nResposta:");
        escolha = sc.nextLine();
        switch (escolha) {
            case "0":
                ITHM.createCliente(sc);
                break;
            case "1":
                ITHM.createOdontologista(sc);
                break;
            case "2":
                ITHM.modificaCliente(sc);
                break;
            case "3":
                ITHM.modificaOdontologista(sc);
                break;
        }
    }

    public static void menuAgendamento(Scanner sc){
        String escolha;
        System.out.println("Digite\n0. Cadastrar Consulta\n1. Modificar Consulta\nResposta:");
        escolha = sc.nextLine();
        switch (escolha) {
            case "0":
                ITHM.createConsulta(sc);
                break;
            case "1":
                ITHM.modificaConsulta(sc);
                break;
        }
    }

    public static void menuConsultas(Scanner sc){
        ArrayList<Consulta> consu = ITHM.consultarAgendamento(sc);
        for (Consulta consulta : consu) {
            System.out.println(consulta);            
        }
    }

    public static void menuRelatorio(Scanner sc){
        Relatorio.clientesAtendidos();
        Relatorio.clientesQueNaoVieram();
        Relatorio.clientesPendentes();
        Relatorio.clientesReagendados();
    }
}
