package atividade.expressao;
import atividade.expressao.dependencias.*;
import atividade.expressao.dependencias.excessao.*;

import java.io.LineNumberReader;
import java.util.LinkedList;
import java.util.Queue;

import org.codehaus.groovy.control.MultipleCompilationErrorsException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;

public class Expressao {
    public static void main(String[] args) throws IOException {
        // passa o caminho do arquivo
        expressao("./src/main/java/atividade/expressao/d14.txt");
    }

    public static void expressao (String path) throws IOException{
        Binding bind = new Binding();
        GroovyShell grovy = new GroovyShell(bind); 
        LineNumberReader leitor = new LineNumberReader(new FileReader(new File(path)));
        int c = 0;
        Queue<String> lista = new LinkedList<>();
        boolean first = true;
        String temp = "";
        // abaixo é adicionado as linhas na fila, isto é, as expressões -> 1 linha == 1 expressão
        while((c = leitor.read()) != -1) {
            if (first){
                temp = "" + (char)c;
                first = false; 
            } else if (c == '\n') {
                if (temp.contains("^")) {
                    // converte o sinal ^ para ** entendido pela lib Groovy
                    lista.add(((temp).replace("^", "**")));
                } else {
                    lista.add(temp);
                }
                first = true;
            } else if (!first && c != '\n') {
                temp += (char)c;
            }
        }
        leitor.close();
        do {
            try{
                System.out.println(grovy.evaluate(lista.poll()));
            } catch (SyntaxErrorExpression e) {
                System.out.println("ERR SYNTAX");
            } catch (ArithmeticException e) {
                System.out.println("ERR DIVBYZERO");
            } catch (MultipleCompilationErrorsException e) {
                System.out.println("ERR SYNTAX");
            } catch (UnsupportedOperationException e) {
            }
        } while (!lista.isEmpty());
    }

    public static Queue<Integer> procura_element(char expressao[]) {
        Queue<Integer> fila = new LinkedList<>();
        int cont = 0;
        for (char c : expressao) {
            if (c == '^') {
                fila.add(cont);
            }
            cont++;
        }
        fila.add(00);
        return fila;
    }
}
