package com.desafio;

/*Escreva um programa para listar todos os números primos entre 1 e 10000*/
public class Primo10000 {
    public static boolean isPrimeNumber(int x) {
        //UM NUMERO PRIMO E UM NUMERO DIVISIVEL APENAS POR 1 E ELE MESMO
        if (x == 1) { //como o numero 1 nao e considerado primo
            return false; //entao 1 especificamente retorna falso
        }
        for (int n = 2; n < x; n++) { //considerando que todo numero natural seja divisivel por 1
            if ((x % n) == 0) { //entao caso o numero seja divisivel por qualquer numero maior que 1 que nao seja ele mesmo
                return false; //a funcao retorna falso
            }
        }
        return true; //se chegou aqui, o numero e primo por nao ser divisivel por nenhum numero natural excluindo 1 menor que ele
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 10000; i++) { //i assume os valores de 1 ate 10000
            if (isPrimeNumber(i)) { //caso i seja primo (funcao retorne true)
                 System.out.printf("%d; ", i); //entao printa o valor de i e ponto virgula
            }
        }
    }
}
