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

    
    // Está função tem por finalidade "juntar" os metodos que serão usados para calcular as raizes
    // Temos que as formulas matematicas divididas em partes
    public void calc_raiz(){
        double delta = delta(getA(), getB(), getC());
        System.out.println(delta);
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
        // Se o expoente(b) = 0 temos que todo numero elevado a 0 é igual a 1 
        if (b == 0){
            return (double)1;
        // Aqui realizamos as multiplicações sucessivas
        } else if(b > 0){
            // modulo_exponenciacao é o motor --> o que realiza as operações coloquei um metodo private a fim de evitar repetição.
            return modulo_exponenciacao(a, b);
        // Semelhante ao metodo anterior aqui realizamos as multiplicações sucessivas quando B é menor que 0, isto é,
        // quando o expoente é negativo
        } else {
            return (1/modulo_exponenciacao(a, b));
        }
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

    // Motor anteriormente citado, responsavel pela exponenciação
    private double modulo_exponenciacao(double a, double b){
        double result = a;
        for(int k = 1; k < b ;k++){
            result *= a;
        }
        return result;
    }
}
