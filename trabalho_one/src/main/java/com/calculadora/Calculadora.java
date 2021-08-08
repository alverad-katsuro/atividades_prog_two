//Classe pertencente ao pacote "classes"
package com.calculadora;
//Importando a função raiz quadrada
import java.lang.Math;

public class Calculadora {
    private double a, b, c;

    // Construtor para o calculo de raizes
    public Calculadora(double a, double b, double c){
        setA(a);
        setB(b);
        setC(c);
        System.out.printf("Você instanciou uma calculadora de raizes a = %.2f b = %.2f c = %.2f %n", getA(), getB(), getC());
    }
    
    // Construtor para o uso da calculadora elementar
    public Calculadora(){
        System.out.println("Você instanciou uma calculadora basica!!");
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

    // Está função tem a responsabilidade de realizar as somas
    public double soma(double a, double b){
        return (a+b);
    }
    
    // Está função tem a responsabilidade de realizar as subtrações
    public double subtracao(double a, double b){
        return (a-b);
    }

    // Está função tem a responsabilidade de realizar e retornar os valores da divisão
    public double divisao(double a, double b){
        return (a/b);
    }

    // Está função tem a responsabilidade retorna o resto da divisão
    public double resto(double a, double b){
        return (a%b);
    }
    
    // Está função tem a responsabilidade retorna o resultado da multiplicação
    public double multiplicacao(double a, double b){
        return (a*b);
    }

    // Aqui temos o metodo responsavel pela potencia
    public double exponenciacao(double a, double b){
        // Realiza a exponenciacao --> importado da biblioteca Math
        return Math.pow(a, b);
    }

    // Definimos o valor de A aqui, para realizarmos as operações envolvendo raizes
    public void setA(double a) {
        this.a = a;
    }

    // Definimos o valor de B aqui, para realizarmos as operações envolvendo raizes
    public void setB(double b) {
        this.b = b;
    }

    // Definimos o valor de C aqui, para realizarmos as operações envolvendo raizes
    public void setC(double c) {
        this.c = c;
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
