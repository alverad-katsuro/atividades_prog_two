import java.util.Random;
import java.util.LinkedHashMap;
import java.util.Scanner;
public class XadrezContagem {
    private static final int NULO = 0;
    private static final int PEAO = 1;
    private static final int BISPO = 2;
    private static final int CAVALO = 3;
    private static final int TORRE = 4;
    private static final int RAINHA = 5;
    private static final int REI = 6;
    private static final int[] PECAS = {NULO, PEAO, BISPO, CAVALO, TORRE, RAINHA, REI};
    public static int[][] construirTab(int[] vetor_e) { //Constroi um Tabuleiro com pecas lidas elemento pro elemento
        int[][] board = new int[8][8]; //Cria o tabuleiro vazio
        int z = 0;
        for (int x = 0; x < 8; x++) { //Percorre o eixo x
            for (int y = 0; y < 8; y++) { //e o eixo y
                board[x][y] = vetor_e[z++]; //colocando na coordenada (x, y) um valor aleatorio
            }                                                  //que esteja no array PECAS
        }
        return board;
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
        int[] arrayy = new int[64]; //
        LinkedHashMap<Integer, Integer> ocorrencias = new LinkedHashMap<Integer, Integer>(); //Cria uma Hash
        for (int i = 0; i < 7; i++) {
            ocorrencias.put(PECAS[i], 0); //Coloca, em ordem, o tipo de peca existente (ou nao existencia)
        }
        for (int x = 0; x < tabuleiro.length; x++) { //eixo x
            for (int y = 0; y < tabuleiro[0].length; y++) { //eixo y
                arrayy[tabuleiro[x][y]] = arrayy[tabuleiro[x][y]] + 1; //Serve para controle
                ocorrencias.put(tabuleiro[x][y], arrayy[tabuleiro[x][y]]); //Coloca Key e Value correspondentes
            } 
        }        
        return ocorrencias; //retorna Hash
    }
    public static void info(LinkedHashMap<Integer, Integer> dados_o) {
        int[] again = new int[7]; //array para o printf
        int a = 0; //controle de atribuicao ao array
        for( Integer key : dados_o.keySet() ){ //para cada chave contida no Set de Chaves
            again[a++] = dados_o.get(key); //atribui a cada posicao do array o numero de vezes que ocorreu cada posicao
         } //como index 0 esta o nulo, again[0] nao sera necessario no printf
         System.out.printf("Peão: %d peça(s)%nBispo: %d peça(s)%nCavalo: %d peça(s)%nTorre: %d peça(s)%nRainha: %d peça(s)%nRei: %d peça(s)", again[1], again[2], again[3], again[4], again[5], again[6]);
    }
    public static void printarTabuleiro(int[][] tabuleiro) {
        for (int x = 0; x < tabuleiro.length; x++) {
            System.out.print("\n");
            for (int y = 0; y < tabuleiro[0].length; y++) {
                System.out.print(tabuleiro[x][y] + " ");
            }
        }   
        System.out.print("\n"); 
    }
    public static void main(String[] args) {
        Scanner for_ints = new Scanner(System.in);
        while (true) {
            System.out.println("DIGITE 1 PARA DIGITAR ELEMENTO POR ELEMENTO\nDIGITE 2 PARA DIGITAR LINHA POR LINHA\nDIGITE 3 PARA CRIAR UM TABULERO ALEATORIO");
            int choose = for_ints.nextInt();
            switch (choose) {
                case (1): {
                    int a = 0;
                    int[] ur_table = new int[64];
                    do {
                        System.out.printf("%d - DIGITE O VALOR DA PECA%n", a);
                        int peca = for_ints.nextInt();
                        if ((peca > -1) && peca < 7) {
                            ur_table[a++] = peca;
                        }
                    } while (a < 64);
                    int[][] t_board = construirTab(ur_table); //cria um tabuleiro aleatorio
                    printarTabuleiro(t_board); //printa esse tabuleiro no console
                    info(contarOcorrencias(t_board)); //printa o numero de ocorrencias
                    for_ints.close();
                    System.exit(0);
                    break;
                }
                case (2): {
                    Scanner for_strings = new Scanner(System.in);
                    int a = 0;
                    int[][] ur_table = new int[8][8];
                    do {
                        System.out.printf("%d - DIGITE A LINHA COM PECAS VALIDAS (APENAS UM ESPACO ENTRE CADA PECA)%n", a);
                        String linha = for_strings.nextLine();
                        String[] new_linha = linha.strip().split(" ");
                        if (new_linha.length == 8) {
                            int m = 0;
                            for (String elemento : new_linha) {
                                try{
                                    int chess_p = Integer.parseInt(elemento);
                                    if ((chess_p > -1) && (chess_p < 7)) {
                                        ur_table[m++][a] = chess_p;
                                    }
                                }
                                catch (NumberFormatException ex){
                                    throw new NumberFormatException("Excecao capturada: Linha com alguma peca invalida!");                                    
                                }
                            }
                            a += 1;
                        }
                    } while (a < 8);
                    printarTabuleiro(ur_table); //printa esse tabuleiro no console
                    info(contarOcorrencias(ur_table)); //printa o numero de ocorrencias
                    for_ints.close();
                    for_strings.close();
                    System.exit(0);
                    break;
                }
                case (3): {
                    int[][] t_board = construirTab(); //cria um tabuleiro aleatorio
                    printarTabuleiro(t_board); //printa esse tabuleiro no console
                    info(contarOcorrencias(t_board)); //printa o numero de ocorrencias
                    for_ints.close();
                    System.exit(0);
                    break;
                }
            }
        }
    }
}