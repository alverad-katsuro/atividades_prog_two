package atividade.expressao.dependencias;
import atividade.expressao.dependencias.excessao.*;

import java.util.ArrayList;

public class Eval {
    public static void main(String[] args) throws SyntaxErrorExpression {
        String operacao = "5/5+2^2";
        calculadora(operacao);
    }

    public static double calculadora(String expressao) throws SyntaxErrorExpression {
        ArrayList<String> expressao_dividida = slice(expressao);
        if (expressao_dividida.contains("(")) {
            slice_parentese(expressao_dividida);
        } else {
            System.out.println(operacoes_basicas(expressao_dividida));
        }
        return 5;
    }

    ////////// tenho que pegar a expressao mais interna (5+5 + (1+2)) -> (1+2) == interna
    public static ArrayList<String> slice_parentese(ArrayList<String> expressao) throws SyntaxErrorExpression {
        if (expressao.contains("(")){
            ArrayList<String> sub_expressao = new ArrayList<>();
            
            int index_ini = expressao.indexOf("(");
            int index_end = expressao.indexOf(")");
            for (int i = 0; i <= index_ini - index_end; i++) {
                String temporaria = expressao.remove(index_ini);
                sub_expressao.add(temporaria);
            }
            System.out.println(sub_expressao);
            return operacoes_basicas(slice_parentese(sub_expressao));
        } else {
            //System.out.println(expressao);
            expressao = operacoes_basicas(expressao);
            return expressao;
        }
    }

    public static String operacaoDoisADois(ArrayList<String> expressao) {
        double result;
        String operador = expressao.remove(1);
        if (operador.equals("+")) {
            result = Calculadora.soma(Double.parseDouble(expressao.remove(0)), Double.parseDouble(expressao.remove(0)));
        } else if(operador.equals("-")){
            result = Calculadora.subtracao(Double.parseDouble(expressao.remove(0)), Double.parseDouble(expressao.remove(0)));
        } else if(operador.equals("*")){
            result = Calculadora.multiplicacao(Double.parseDouble(expressao.remove(0)), Double.parseDouble(expressao.remove(0)));
        } else if(operador.equals("/")){
            result = Calculadora.divisao(Double.parseDouble(expressao.remove(0)), Double.parseDouble(expressao.remove(0)));
        } else {
            result = Calculadora.exponenciacao(Double.parseDouble(expressao.remove(0)), Double.parseDouble(expressao.remove(0)));
        }
        return (String.valueOf(result));
    }

    public static ArrayList<String> operacoes_basicas(ArrayList<String> expressao) {
        String operacoes[] = {"^", "/", "*", "+", "-"};
        for (String operacao : operacoes) {
            expressao = operacoes_basicas_modulo(expressao, operacao);
        }
        return expressao;
    }

    public static ArrayList<String> operacoes_basicas_modulo(ArrayList<String> expressao, String operacao) {
        ArrayList<String> sub_expressao = new ArrayList<>();
        while (true){
            if (expressao.contains(operacao)) {
                int index_ini = expressao.indexOf(operacao) - 1;
                for (int i = 0; i < 3; i++) {
                    sub_expressao.add(expressao.remove(index_ini));
                }
                if (expressao.isEmpty()) {
                    expressao.add(operacaoDoisADois(sub_expressao));
                } else {
                    expressao.add(index_ini, operacaoDoisADois(sub_expressao));
                }
            } else {
                sub_expressao.clear();
                break;
            }
        }
        return expressao;
    }

    public static ArrayList<String> slice(String expressao) throws SyntaxErrorExpression {
        procura_erro(expressao);
        ArrayList<String> expressao_dividida = new ArrayList<>();
        for (String string : expressao.replace(" ", "").split("")) {
            expressao_dividida.add(string);
        }
        if ("+-/^*".contains(expressao_dividida.get(0)) || "+-/^*".contains(expressao_dividida.get(expressao_dividida.size()-1))){
            throw new SyntaxErrorExpression();
        } else {
            return expressao_dividida;
        }
    }

    public static void procura_erro(String expressao) throws SyntaxErrorExpression{
        // verifica se há erro de sintaxe ex: + +, - -, etc
        String teste[] = {"+", "-", "/", "*", "^"};
        for (String string : teste) {
            for (String string2 : teste) {
                if (expressao.contains(string + " " + string2) || expressao.contains(string + string2)){
                    throw new SyntaxErrorExpression();
                }
            }    
        }
        if (expressao.contains("(") || expressao.contains(")")){
            int direita=0, esquerda=0;
            for (String string : expressao.split("")) {
                if (string.equals("(")) {
                    esquerda += 1;
                } else if (string.equals(")")){
                    direita += 1;
                }
            }
            if (direita != esquerda) {
                throw new SyntaxErrorExpression();
            }
        }
    }
}
