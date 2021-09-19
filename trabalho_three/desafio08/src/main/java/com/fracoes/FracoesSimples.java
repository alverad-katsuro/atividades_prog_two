package com.fracoes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Set;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Collections;
 public class FracoesSimples {
    public static int mdc(int n1, int n2) {
      Set<Integer> a1 = new HashSet<>(); //Conjunto para n1
      Set<Integer> a2 = new HashSet<>(); //Conjunto para n2
      for (int i = 2; i <= n1; i++) {
        if ((n1%i) == 0) {
          a1.add(i); //Adiciona os divisores de n1 para a1
        }
      }
      for (int j = 2; j <= n2; j++) {
        if ((n2%j) == 0) {
          a2.add(j); //Adiciona os divisores de n2 para a2
        }
      }
      try {
        a1.retainAll(a2); //a1 Uniao a2 (caso nao exista elementos em a1/a2 vai dar erro da linha 27)
        int mdc = Collections.max(a1); //Maior valor no Set (caso nao exista valores no set, erro da linha 27)
        return mdc; //retorna o maior divisor comum entre n1 e n2
      }
      catch (NoSuchElementException e) {
        return -1; //caso nao exista divisor comum, entao retorna -1
      }

    }
    public static void main(String[] args) throws IOException {
        String fileName = "frac.txt"; //nome do arquivo
        File file = new File(fileName);   //arquivo
        byte[] fileContent = Files.readAllBytes(file.toPath()); //conteudo do arquivo sendo lido
        String expression = ""; //(conteudo da linha em especifico)
        String expression2 = ""; //(controle do valors(s) contidos na linha em especifico)
        int n1 = 0; //controle de variavel
        int n2 = 1; //controle de variavel
        boolean o1 = false; //controle de operacao
        for(byte b : fileContent) { //pra cada byte no arquivo sendo lido
          char singleChar = (char) b; //transforma em caractere
          if (((int) singleChar) == 10) { //se o ascii do caractere for igual a 10 (enter/new space)
            for (int a = 0; a < expression.length(); a++) { //pra cada caractere na string expression 
              if (((int) expression.charAt(a)) == 47) { //se o ascii do caractere seja igual a 47 (/ simbolo da divisao)
                n1 = Integer.parseInt(expression2); //converte o valor para um numero inteiro e armazena em n1
                expression2 = "";
                o1 = true; //e indica que ha uma divisao explicita
                continue; //pula pra proxima iteracao pra que expression2 nao armazena o simbolo de divisao
              }
              expression2 += expression.charAt(a); //armazena o numero (ainda em string) indo byte por byte
              if (a == (expression.length() - 1)) { //caso esteja no final da linha
                if (o1 == false) { //se a divisao nao foi explicita
                  n1 = Integer.parseInt(expression2); //entao so ha um numero
                  n2 = 1; //e o segundo e o 1 implicito
                  expression2 = "";
                }
                else { //se foi explicita
                  n2 = Integer.parseInt(expression2); //entao ja percorreu o if anterior e entao esse e o segundo numero
                  expression2 = "";
                }
              }
            }
            if ((n1 == n2) || (n2 == 1)) { //caso a divisao seja entre numeros iguais ou com 1 explicito/implicito
              o1 = false; //nao precisa desse operador
            }
            if (o1 == true) { //caso o operador nao se enquadre na linha 64
              try {
                if ((n1/n2) != 0) { //se a divisao exata nao der igual a zero
                  System.out.printf("%d %d/%d%n", (n1/n2), (n1%n2), n2); //entao faz a simplificacao
                }
                else { //caso a divisao exata seja igual a zero
                  int this_mdc = mdc(n1, n2); //tira o mdc entre o numerador e o denominador
                  if (this_mdc != -1) { //se o mdc existir
                    System.out.printf("%d/%d%n", n1/this_mdc, n2/this_mdc); //simplifica e printa o resultado
                  }
                  else { //se nao existir
                    System.out.printf("%d/%d%n", n1, n2); //entao nao tem como simplificar
                  }
                }
                o1 = false; //e, resetando pra proxima linha, operador ainda nao existira
              }
              catch (ArithmeticException e) {
                System.out.println("ERR"); //DIVISAO POR ZERO

              }

            }
            else { //caso o operador se enquadre na linha 64
              System.out.printf("%d%n", (n1/n2)); //entao basta printar o valor da divisao exata entre o numerador e o denominador
            }
            expression = ""; //reseta a palavra para a proxima linha
            continue; //sai do for sem juntar em expression a quebra de linha
          }
          expression += singleChar; //vai juntando em expression o conteudo da linha
        }
    }
}
