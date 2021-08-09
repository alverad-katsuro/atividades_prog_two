package com.calculadora;

public class Calculadora_raiz extends Calculadora{
    private double a, b, c;

    // Construtor para o calculo de raizes
    public Calculadora_raiz(double a, double b, double c){
        setA(a);
        setB(b);
        setC(c);
        System.out.println("Você instanciou uma calculadora de raizes!");
        System.out.printf("a = %.2f b = %.2f c = %.2f %n", getA(), getB(), getC());
    }
    
    // Está função tem por finalidade "juntar" os metodos que serão usados para calcular as raizes
    // Temos que as formulas matematicas divididas em partes
    public void calc_raiz(){
        double delta = delta(getA(), getB(), getC());
        if (delta > 0) {
            System.out.println("Duas raizes reais e diferentes");
        }
        else if (delta == 0) {
            System.out.println("Duas raizes reais e iguais");
        }
        else if (delta < 0) {
            System.out.println("Sem raizes reais");
        }
        System.out.printf("A primeira raiz é: %.2f%n", raiz_one(getA(), getB(), delta));
        System.out.printf("A segunda raiz é: %.2f%n", raiz_two(getA(), getB(), delta));
    }

    // Metodo para sabermos o valor de A
    public double getA() {
    return a;
    }
    
    // Metodo para sabermos o valor de B
    public double getB() {
        return b;
    }
    
    // Metodo para sabermos o valor de C
    public double getC() {
        return c;
    }
    
    // Definimos o valor de A aqui, para realizarmos as operações envolvendo raizes
    private void setA(double a) {
        this.a = a;
    }

    // Definimos o valor de B aqui, para realizarmos as operações envolvendo raizes
    private void setB(double b) {
        this.b = b;
    }

    // Definimos o valor de C aqui, para realizarmos as operações envolvendo raizes
    private void setC(double c) {
        this.c = c;
    }

    // Função que calcula o valor de delta usando metodos feitos anteiormente
    private double delta(double a, double b, double c){
        return (multiplicacao(b,b) - (multiplicacao((double)4, multiplicacao(a,c))));
    }

    // Função que calcula o valor de da primeira raiz
    private double raiz_one(double a, double b, double delta) {
        return divisao(soma(multiplicacao(-1, b), Math.sqrt(delta)), (2*a));
    }

    // Função que calcula o valor de da segunda raiz
    private double raiz_two(double a, double b, double delta) {
        return divisao(subtracao(multiplicacao(-1, b), Math.sqrt(delta)), (2*a));
    }
}
