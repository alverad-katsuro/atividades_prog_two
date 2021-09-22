package atividade.expressao;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.LinkedList;
import java.util.Queue;

import atividade.expressao.dependencias.Eval;
import atividade.expressao.dependencias.excessao.SyntaxErrorExpression;

public class Expressao {
    public static void main(String[] args) throws IOException {
        // passa o caminho do arquivo
        expressao("./src/main/java/atividade/expressao/d14.txt");
    }

    public static void expressao (String path) throws IOException{
        LineNumberReader leitor = new LineNumberReader(new FileReader(new File(path)));
        Queue<String> lista = new LinkedList<>();
        // abaixo é adicionado as linhas na fila, isto é, as expressões -> 1 linha == 1 expressão
        while(leitor.ready()) {
            lista.add(leitor.readLine());
        }
        leitor.close();
        do {
            try{
                System.out.println(Eval.calculadora(lista.poll()));
            } catch (SyntaxErrorExpression e) {
                System.out.println("ERR SYNTAX");
            } catch (ArithmeticException e) {
                System.out.println("ERR DIVBYZERO");
            }
        } while (!lista.isEmpty());
    }
}
