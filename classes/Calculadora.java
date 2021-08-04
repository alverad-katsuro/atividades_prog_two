//Classe pertencente ao pacote "classes"
package classes;
//Importando a função raiz quadrada
import java.lang.Math;

public class Calculadora {
    private double a, b, c;

    // Construtor para o calculo de raizes
    public Calculadora(double a, double b, double c){
        setA(a);
        setB(b);
        setC(c);
        System.out.printf("Você instanciou uma calculadora de raizes a = %.2f b = %.2f c = %.2f", getA(), getB(), getC());
    }
    
    // Construtor para o uso da calculadora elementar
    public Calculadora(){
        System.out.println("Você instanciou uma calculadora basica!!");
    }

    public void calc_raiz(){
        double delta = delta(getA(), getB(), getC());
        System.out.println(delta);
        System.out.printf("A primeira raiz é: %.2f%n", raiz_one(getA(), getB(), delta));
        System.out.printf("A segunda raiz é: %.2f%n", raiz_two(getA(), getB(), delta));
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

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    private double delta(double a, double b, double c){
        return (multiplicacao(b,b) - (multiplicacao((double)4, multiplicacao(a,c))));
    }

    private double raiz_one(double a, double b, double delta) {
        return divisao(soma(multiplicacao(-1, b), Math.sqrt(delta)), (2*a));
    }

    private double raiz_two(double a, double b, double delta) {
        return divisao(subtracao(multiplicacao(-1, b), Math.sqrt(delta)), (2*a));
    }

    private double modulo_exponenciacao(double a, double b){
        double result = a;
        for(int k = 1; k < b ;k++){
            result *= a;
        }
        return result;
    }
}
