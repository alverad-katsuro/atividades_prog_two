package classes;

import java.util.Scanner;

public class Menu {
    private Calculadora calc;

    public void start(){
        Scanner sc = new Scanner(System.in);
        byte o_que_fazer;
        boolean cont = true;
        while (cont) {
            System.out.printf("Digite:\n0. Sair do Programa\n1. Calculadora\n2. Calculadora de Raizes\nEscolha: ");
            o_que_fazer = sc.nextByte();
            switch (o_que_fazer) {
                case 0:
                    cont = false;
                    break;
                case 1:
                    System.out.printf("Digite:\n0. Soma\n1. Subtração\n2. Divisão\n3. Multipicação\n4. Exponenciação a^b\n5. Resto da Divisão\nEscolha: ");
                    byte escolha = sc.nextByte();
                    System.out.printf("Digite o primeiro valor: ");
                    double a = sc.nextDouble();
                    System.out.printf("Digite o segundo valor: ");
                    double b = sc.nextDouble();
                    setCalc(new Calculadora());
                    switch (escolha) {
                        case 0:
                            double result_s = getCalc().soma(a, b);
                            saida(result_s);
                            break;
                        case 1:
                            double result_sub = getCalc().subtracao(a, b);
                            saida(result_sub);
                            break;
                        case 2:
                            double result_div = getCalc().divisao(a, b);
                            saida(result_div);
                            break;
                        case 3:
                            double result_mult = getCalc().multiplicacao(a, b);
                            saida(result_mult);
                            break;
                        case 4:
                            double result_exp = getCalc().exponenciacao(a, b);
                            saida(result_exp);
                            break;    
                        case 5:
                            double result_rest = getCalc().resto(a, b);
                            saida(result_rest);
                            break;
                    }
                    break;
                case 2:
                    System.out.printf("Digite o primeiro valor: ");
                    double a_r = sc.nextDouble();
                    System.out.printf("Digite o segundo valor: ");
                    double b_r = sc.nextDouble();
                    System.out.printf("Digite o terceiro valor: ");
                    double c_r = sc.nextDouble();
                    setCalc(new Calculadora(a_r, b_r, c_r));
                    getCalc().calc_raiz();
                    break;
            }
        }
    }

    private void saida(double func){
        System.out.printf("O resultado é: %d%n", func);
    }

    public void setCalc(Calculadora calc) {
        this.calc = calc;
    }

    public Calculadora getCalc() {
        return calc;
    }
}
