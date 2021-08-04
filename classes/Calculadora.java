package classes;

import java.lang.Math;

public class Calculadora {

    public Calculadora(double a, double b, double c){
        double delta = delta(a, b, c);
        System.out.printf("A primeira raiz é: $d$n", raiz_one(a, b, delta));
        System.out.printf("A segunda raiz é: $d$n", raiz_two(a, b, delta));
    }

    public Calculadora(double a, double b){
        
    }

    public double soma(double a, double b){
        return (a+b);
    }

    public double subtracao(double a, double b){
        return (a-b);
    }

    public double divisao(double a, double b){
        return (a/b);
    }

    public double resto(double a, double b){
        return (a%b);
    }

    public double multiplicacao(double a, double b){
        return (a*b);
    }

    public double exponenciacao(double a, double b){
        if (b == 0){
            return (double)1;
        } else if(a > 0){
            return modulo_exponenciacao(a, b);
        } else {
            return (1/modulo_exponenciacao(a, b));
        }
    }

    private double delta(double a, double b, double c){
        return ((multiplicacao(b,b)) - (multiplicacao((double)4, multiplicacao(a,c))));
    }

    private double raiz_one(double a, double b, double delta) {
        return (soma((multiplicacao(-1, b)), divisao((Math.sqrt(delta)),(2*a))));
    }

    private double raiz_two(double a, double b, double delta) {
        return (subtracao((multiplicacao(-1, b)), divisao((Math.sqrt(delta)),(2*a))));
    }

    private double modulo_exponenciacao(double a, double b){
        double result = a;
        for(int k = 0; k < b ;k++){
            result *= a;
        }
        return result;
    }
}
