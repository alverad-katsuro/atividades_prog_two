package com.calculadora;

// Aqui é importado o Scanner --> metodo que permite receber dados do teclado.
import java.util.Scanner;

public class Menu {
    // Declaração da variavel que será responsavel pela CALCULADORA.

    public static void main(String[] args) {
        // DECLARAÇÃO de VARIAVEIS
        Scanner sc = new Scanner(System.in);
        byte o_que_fazer;
        // FIM
        while (true) {
            // Aqui temos o menu que será exibido ao usuario
            System.out.printf("\033[1;34mDigite:\n0. Sair do Programa\n1. Calculadora\n2. Calculadora de Raizes\nEscolha: \033[1;97m");
            // Entrada do Usuario
            o_que_fazer = sc.nextByte();
            // Laço condicional --> vai variar de acordo com a entrada do usuario.
            switch (o_que_fazer) {
                // Para o laço caso 0
                case 0:
                    sc.close();
                    System.exit(0);
                    break;
                // Vai para Calculadora
                case 1:
                    // Aqui temos o um submenu que será exibido ao usuario com as operações basicas
                    System.out.printf("\033[1;34mDigite:\n +. Soma\n -. Subtração\n /. Divisão\n *. Multipicação\n ^. Exponenciação a^b\n %%. Resto da Divisão\nEscolha: \033[1;97m");
                    char escolha = sc.next().charAt(0);
                    System.out.printf("\033[1;34mDigite o primeiro valor: \033[1;97m");
                    double a = sc.nextDouble();
                    System.out.printf("\033[1;34mDigite o segundo valor: \033[1;97m");
                    double b = sc.nextDouble();
                    Calculadora calculadora = new Calculadora();
                    // Laço condicional --> vai variar de acordo com a entrada do usuario.
                    switch (escolha) {
                        case '+':
                            // Resultado da operação de soma está armazenada em result
                            double result_s = calculadora.soma(a, b);
                            // Temos a saida do resultado para o usuario
                            saida(result_s);
                            break;
                        case '-':
                            // Resultado da operação de subtração está armazenada em result
                            double result_sub = calculadora.subtracao(a, b);
                            // Temos a saida do resultado para o usuario
                            saida(result_sub);
                            break;
                        case '/':
                            // Resultado da operação de divisao está armazenada em result
                            double result_div = calculadora.divisao(a, b);
                            // Temos a saida do resultado para o usuario
                            saida(result_div);
                            break;
                        case '*':
                            // Resultado da operação de multiplicacao está armazenada em result
                            double result_mult = calculadora.multiplicacao(a, b);
                            // Temos a saida do resultado para o usuario
                            saida(result_mult);
                            break;
                        case '^':
                            // Resultado da operação de exponenciacao está armazenada em result
                            double result_exp = calculadora.exponenciacao(a, b);
                            // Temos a saida do resultado para o usuario
                            saida(result_exp);
                            break;    
                        case '%':
                            // Resultado da operação Resto da divisão está armazenada em result
                            double result_rest = calculadora.resto(a, b);
                            // Temos a saida do resultado para o usuario
                            saida(result_rest);
                            break;
                    }
                    break;
                // Vai para calculadora de raizes
                case 2:
                    // ENTRADAS DO USUARIO QUANDO AOS VALORES ax² + bx + c
                    System.out.printf("\033[1;34mDigite o valor de a: \033[1;97m");
                    double a_r = sc.nextDouble();
                    System.out.printf("\033[1;34mDigite o valor de b: \033[1;97m");
                    double b_r = sc.nextDouble();
                    System.out.printf("\033[1;34mDigite o valor de c: \033[1;97m");
                    double c_r = sc.nextDouble();
                    // FIM
                    // Instancia da calculadora de raizes
                    Calculadora calculadora_r = new Calculadora(a_r, b_r, c_r);
                    // Chamando o metodo que calcula raizes
                    calculadora_r.calc_raiz(); 
                    break;
            }
        }
    }

    // METODO que exibe o resultado da calculadora basica para os usuarios
    private static void saida(double func){
        System.out.printf("O resultado é: %.2f%n", func);
    }
}
