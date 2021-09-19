package atividade.expressao.dependencias;
import atividade.expressao.dependencias.excessao.*;

import java.util.ArrayList;

public class Eval {
    public static void main(String[] args) {
        String teste = "5+5-2";
        String teste2 = "5 + 5 - 2";
        try{
            teste();
        } catch (SyntaxErrorExpression e){
            System.out.println("aaaaaaaaaa");
        }
    }

    public static SyntaxErrorExpression teste() throws SyntaxErrorExpression{
        throw new SyntaxErrorExpression();
    }

    public static double calculadora(String expressao) {
        return 5;
    }

    public static ArrayList<String> naoseinome(String expressao) {
        ArrayList<String> expressao_dividida = new ArrayList<>();
        
        return expressao_dividida;
    }

    public static String procura_erro(String expressao){
        boolean erro = false;
        // verifica se há erro de sintaxe ex: + +, - -, etc
        String teste[] = {"+", "-", "/", "*", "^"};
        for (String string : teste) {
            for (String string2 : teste) {
                if (expressao.contains(string + " " + string2)){
                    erro = true;
                    break;
                }
            }    
        }
        if (erro){
            //throw new SyntaxErrorExpression();
        }
        return expressao;
    }
}
