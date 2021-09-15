package atividade.expressao;

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
        while((c = leitor.read()) != -1) {
            if (first){
                temp = "" + (char)c;
                first = false; 
            } else if (c == '\n') {
                if (temp.contains("^")) {
                    lista.add(arruma_expressao(temp));
                } else {
                    lista.add(temp);
                }
                first = true;
            } else if (!first && c != '\n') {
                temp += (char)c;
            }
        }
        if (temp.contains("^")) {
            lista.add(arruma_expressao(temp));
        } else {
            lista.add(temp);
        }
        leitor.close();
        do {
            try{
                String saida = lista.poll();
                boolean erro = false;
                String teste[] = {"+", "-", "/", "*", "^"};
                for (String string : teste) {
                    for (String string2 : teste) {
                        if (saida.contains(string + " " + string2)){
                            erro = true;
                            break;
                        }
                    }    
                }
                if (erro){
                    System.out.println("ERR SYNTAX");
                } else {
                    System.out.println(grovy.evaluate(saida));
                }
            } catch (ArithmeticException e) {
                System.out.println("ERR DIVBYZERO");
            } catch (MultipleCompilationErrorsException e) {
                System.out.println("ERR SYNTAX");
            } catch (UnsupportedOperationException e) {
            }
        } while (!lista.isEmpty());
    }

    public static String arruma_expressao(String expressao) {
        char char_temp[] = expressao.toCharArray();
        Queue<Integer> fila = procura_element(char_temp);
        int index = fila.poll();
        do {
            for (int i = index; i < expressao.length(); i++) {
                if (index + 1 == i) {
                } else if (i + 1 == expressao.length()) {
                    char_temp = ((new String(char_temp)) + ')').toCharArray();
                }else if (char_temp[i] == ' ') {
                    char_temp[i] = ')';
                    break;
                } else if (char_temp[i] == ')'){
                    break;
                }
            }
            for (int i = index; i >= 0; i--) {
                if (index - 1 == i) {
                } else if (i == 0){
                    char_temp = ('(' + (new String(char_temp))).toCharArray();
                }else if (char_temp[i] == ' ') {
                    char_temp[i] = '(';
                    break;
                } else if (char_temp[i] == '('){
                    break;
                }
            }
            index = fila.poll();
        } while (!fila.isEmpty());
        return (new String(char_temp));
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
        fila.add(0);
        return fila;
    }
}
