//Classe pertencente ao pacote "classes"
package com.calculadora;
//Importando a função raiz quadrada
import java.lang.Math;

public class Calculadora {

    // Construtor para o uso da calculadora elementar
    public Calculadora(){
        System.out.println("Você instanciou uma calculadora basica!");
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
}
