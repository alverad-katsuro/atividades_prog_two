package com.system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Interface interface_one = new Interface(sc);
        while (true) {
            System.out.println("1. REGISTRAR FUNCIONARIO\n2. ENCONTRAR FUNCIONARIO\n3. ATUALIZAR OS DADOS\n4. DEMITIR FUNCIONARIO\n5. VISUALIZAR SETORES");
            System.out.printf("\nESCOLHER AÇÃO: ");
            int main_action = sc.nextInt();
            sc.nextLine(); 
            if (main_action == 0) {
                break;
            }
            menuInicial(interface_one, sc, main_action);
        }
        sc.close();
    }

    private static void menuInicial(Interface interface_one, Scanner sc, int main_action) throws Exception{        
        switch (main_action) {
            case (1): {
                interface_one.admitirFuncionario(sc);
                break;
            }
            case (2): {
                interface_one.buscarFuncionario(sc);
                break;
            }
            case (3): {
                interface_one.atualizarFuncionario(sc);
                break;
            }
            case (4): {
                interface_one.demitirFuncionario(sc);
                break;
            }
            case (5): {
                interface_one.informacoesSetor(sc);
                break;
            }
        }
    }

    
}
