package com.system;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Funcionario funcionario = new Funcionario();
        funcionario.defineDataNascimento(sc);
        System.out.println(funcionario.getIdade());
    }

    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
}
