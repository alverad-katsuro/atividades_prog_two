package com.system;

import java.util.Scanner;
import java.util.UUID;

public class Teste {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Interface interface_one = new Interface(sc);
        interface_one.admitirFuncionario(sc);
        interface_one.buscarFuncionario(sc);
        /*
        */
    }
}
