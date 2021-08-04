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
                    System.out.printf("Digite:\n0. Soma\n1. Subtração\n2. Divisão\n3. Multipicação\n4. Exponenciação x1^x2\n5. Resto da Divisão\nEscolha: ");
                    byte escolha = sc.nextByte();
                    System.out.printf("Digite o primeiro valor: ");
                    double a = sc.nextDouble();
                    System.out.printf("Digite o segundo valor: ");
                    double b = sc.nextDouble();
                    setCalc(new Calculadora(a, b, escolha));
                    break;
                case 2:
                    System.out.printf("Digite o primeiro valor: ");
                    double a_r = sc.nextDouble();
                    System.out.printf("Digite o segundo valor: ");
                    double b_r = sc.nextDouble();
                    System.out.printf("Digite o terceiro valor: ");
                    double c_r = sc.nextDouble();
                    setCalc(new Calculadora(a_r, b_r, c_r));
                    break;
            }
        }
    }
    public void setCalc(Calculadora calc) {
        this.calc = calc;
    }

    public Calculadora getCalc() {
        return calc;
    }
}
