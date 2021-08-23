package com.system;

import java.util.Scanner;
import java.util.UUID;

public class Teste {
    public static void main(String[] args) throws Exception {
        System.out.println(teste(1));
        /*
        Scanner sc = new Scanner(System.in);
        Interface interface_one = new Interface(sc);
        interface_one.admitirFuncionario(sc);
        interface_one.buscarFuncionario(sc);
        */
    }

    public static String teste(int x){
        if (x == 5) {
            return "AA";
        }
        return null;
    }
}
