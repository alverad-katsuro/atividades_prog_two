package com.xadrez;

import java.util.Random;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class XadrezContagem {
    private static final int NULO = 0; //CONSTANTE PARA CADA PECA OU AUSENCIA DA MESMA
    private static final int PEAO = 1;
    private static final int BISPO = 2;
    private static final int CAVALO = 3;
    private static final int TORRE = 4;
    private static final int RAINHA = 5;
    private static final int REI = 6;
    private static final int[] PECAS = {NULO, PEAO, BISPO, CAVALO, TORRE, RAINHA, REI}; //VETOR COM AS PECAS
    public static int[][] construirTab(int[] vetor_e) { //Constroi um Tabuleiro com pecas lidas elemento pro elemento
        int[][] board = new int[8][8]; //Cria o tabuleiro vazio
        int z = 0;
        for (int x = 0; x < 8; x++) { //Percorre o eixo x
            for (int y = 0; y < 8; y++) { //e o eixo y
                board[x][y] = vetor_e[z++]; //colocando na coordenada (x, y) o valor correspondente do usuario
            }                                                 
        }
        return board; //retorna o tabuleiro preenchido
    }

    public static int[][] construirTab() { //Constroi um Tabuleiro com pecas aleatoriamente colocadas
        int[][] board = new int[8][8]; //Cria o tabuleiro vazio
        Random generator = new Random(); //Cria o randomizador
        for (int x = 0; x < 8; x++) { //Percorre o eixo x
            for (int y = 0; y < 8; y++) { //e o eixo y
                board[x][y] = generator.nextInt(PECAS.length); //colocando na coordenada (x, y) um valor aleatorio
            }                                                  //que esteja no array PECAS
        }
        return board; //Retorna o tabuleiro preenchido
    }
    public static LinkedHashMap<Integer, Integer> contarOcorrencias(int[][] tabuleiro) { //Contabiliza quantas vezes uma peça apareceu no tabuleiro
        int[] arrayy = new int[7]; //vetor correspondente pra contagem de cada peca (6 pecas + nulo = tamanho 7)
        LinkedHashMap<Integer, Integer> ocorrencias = new LinkedHashMap<Integer, Integer>(); //Cria uma Hash pra corresponder peca com contagem
        for (int i = 0; i < 7; i++) { //Cria as keys da Hash na ordem do vetor PECAS
            ocorrencias.put(PECAS[i], 0); //Coloca, em ordem, o tipo de peca existente (ou nao existencia)
        }
        for (int x = 0; x < tabuleiro.length; x++) { //eixo x
            for (int y = 0; y < tabuleiro[0].length; y++) { //eixo y
                arrayy[tabuleiro[x][y]] = arrayy[tabuleiro[x][y]] + 1; //array que vai somando +1 no index correspondente a peca
                ocorrencias.put(tabuleiro[x][y], arrayy[tabuleiro[x][y]]); //Coloca Key e Value correspondentes pra Hash
            } 
        }        
        return ocorrencias; //retorna Hash
    }
    
    public static void info(LinkedHashMap<Integer, Integer> dados_o) {
         System.out.printf("Peão: %d peça(s)%n", dados_o.get(1));
         System.out.printf("Bispo: %d peça(s)%n", dados_o.get(2));
         System.out.printf("Cavalo: %d peça(s)%n", dados_o.get(3));
         System.out.printf("Torre: %d peça(s)%n", dados_o.get(4));
         System.out.printf("Rainha: %d peça(s)%n", dados_o.get(5));
         System.out.printf("Rei: %d peça(s)%n", dados_o.get(6));
    }
    
    public static void printarTabuleiro(int[][] tabuleiro) {
        for (int x = 0; x < tabuleiro.length; x++) {
            System.out.print("\n"); //espaco para quebrar linha
            for (int y = 0; y < tabuleiro[0].length; y++) {
                System.out.print(tabuleiro[x][y] + " "); //printa linha
            }
        }   
        System.out.print("\n"); 
    }
    public static void main(String[] args) {
        Scanner for_ints = new Scanner(System.in);
        while (true) {
            System.out.println("DIGITE 1 PARA DIGITAR ELEMENTO POR ELEMENTO\nDIGITE 2 PARA DIGITAR LINHA POR LINHA\nDIGITE 3 PARA CRIAR UM TABULERO ALEATORIO");
            int choose = for_ints.nextInt(); //input do usuario
            switch (choose) {
                case (1): {
                    int a = 0; //controle de posicao
                    int[] ur_table = new int[64]; //armazena o valor de cada posicao do usuario
                    do {
                        //System.out.printf("%d - DIGITE O VALOR DA PECA%n", a);
                        // tem que ver como limpa tela eu n sei hahaha
                        imprime(ur_table, a);
                        int peca = for_ints.nextInt(); //deve ser entre -1 e 7 (sem extremos) para pular iteracao
                        if ((peca > -1) && peca < 7) {
                            ur_table[a++] = peca; //armazena no array o valor do input
                        }
                        if (a % 8 == 0) {
                            imprime(ur_table, a);
                        }
                    } while (a < 64); //ate ter 64 pecas selecionadas
                    int[][] t_board = construirTab(ur_table); //cria um tabuleiro de elementos selecionados
                    printarTabuleiro(t_board); //printa esse tabuleiro no console
                    info(contarOcorrencias(t_board)); //printa o numero de ocorrencias
                    for_ints.close(); //fecha scanner
                    System.exit(0); //fecha programa
                    break;
                }
                case (2): {
                    Scanner for_strings = new Scanner(System.in);
                    int a = 0; //controle de linha
                    int[][] ur_table = new int[8][8]; //array do tabuleiro
                    do {
                        System.out.printf("%d - DIGITE A LINHA COM PECAS VALIDAS (APENAS UM ESPACO ENTRE CADA PECA)%n", a);
                        String linha = for_strings.nextLine(); //input
                        String[] new_linha = linha.strip().split(" "); //tira espacos do inicio e final, e remove os "UM ESPACO" entre cada peca
                        if (new_linha.length == 8) { //caso tenha 8 elementos na linha
                            int m = 0;
                            for (String elemento : new_linha) {
                                try{
                                    int chess_p = Integer.parseInt(elemento); //transforma codigo da peca (string) em inteiro
                                    if ((chess_p > -1) && (chess_p < 7)) {
                                        ur_table[a][m++] = chess_p; //e adiciona na linha correspondente esse inteiro caso seja valido
                                    }
                                }
                                catch (NumberFormatException ex){
                                    throw new NumberFormatException("Excecao capturada: Linha com alguma peca invalida!"); //se o usuario colocar nao numero na linha                              
                                }
                            }
                            a += 1; //controle de linha
                        }
                    } while (a < 8);
                    printarTabuleiro(ur_table); //printa esse tabuleiro no console
                    info(contarOcorrencias(ur_table)); //printa o numero de ocorrencias
                    for_ints.close(); //fecha scanner
                    for_strings.close(); //fecha scanner
                    System.exit(0); //fecha programa
                    break;
                }
                case (3): {
                    int[][] t_board = construirTab(); //cria um tabuleiro aleatorio
                    printarTabuleiro(t_board); //printa esse tabuleiro no console
                    info(contarOcorrencias(t_board)); //printa o numero de ocorrencias
                    for_ints.close(); //fecha scanner
                    System.exit(0); //fecha programa
                    break;
                }
            }
        }
    }

    public static void imprime(int vetor[], int posicao) {
        if (posicao == 0) {
            System.out.println("DIGITE O VALOR DA PECA");
        } else {
            String saida = "";
            int intervalos_existentes[] = {8,16,24,32,40,48,56,64};
            int intervalo = 8;
            for (int j : intervalos_existentes) {
                if (posicao < j) {
                    intervalo = j;
                    break;
                }
            }
            for (int j = intervalo - 8; j < intervalo; j++) {
                saida += vetor[j] +" ";
            }
            System.out.println("DIGITE O VALOR DA PECA");
            System.out.printf("%s ", saida);
        }
        
    }

}
