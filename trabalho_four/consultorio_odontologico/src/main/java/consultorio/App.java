package consultorio;

import consultorio.bd.Atualizar_Dados;
import consultorio.classes.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Odontologista odo = new Odontologista("nome", "cpf", "telefone", "email", "MASCULINO", 5, "pais", "estado", "cidade", "bairro", "rua", "numero", "complemento", "sadasdsad", "PROTETICO");
        Atualizar_Dados.insertDentista(odo);

        /*
        Scanner sc = new Scanner(System.in);
        boolean cont = true;
        String escolhas;
        while (cont) {
            System.out.println("--------- Bem Vindo a OdontoLab ---------");
            System.out.println("Digite\n0. Cadastro\n1. Agendamento\n2. Consultas\n3. Relatorio\n4. Sair");
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
        sc.close();
         */
    }

    public static void menuCadastro(Scanner sc){
        String escolha;
        System.out.println("Digite\n0. Cadastro Cliente\n1. Cadastro Odontologista");
        escolha = sc.nextLine();
        switch (escolha) {
            case "0":
                ITHM.createCliente(sc);
                break;
            case "1":
                ITHM.createOdontologista(sc);
        }
    }

    public static void menuAgendamento(Scanner sc){
        ITHM.createConsulta(sc);
    }

    public static void menuConsultas(Scanner sc){
        ITHM.consultarAgendamento(sc);
    }

    public static void menuRelatorio(Scanner sc){

    }
}
