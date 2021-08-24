package com.system;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) throws Exception {
        Funcionario funcionario = new Funcionario();
        Scanner sc = new Scanner(System.in);
        funcionario.setFerias(sc);
    }
}
