import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Stack;

public class Tac {
    public static void main(String[] path) throws IOException {
        long qt_char_linhas[] = count(path[0]);
        long linhas_totais = qt_char_linhas[1];
        long linha_ini = 0, linha_stop = 0;
        int linhas_a_serem_lidas;
        if (path.length > 1) {
            linhas_a_serem_lidas = (Integer.parseInt(path[1]) - 80) * 1024* 1024 / (2*(((int)(qt_char_linhas[0]/qt_char_linhas[1])) + 1));
        } else {
            linhas_a_serem_lidas = 400 * 1024* 1024 / (2*(((int)(qt_char_linhas[0]/qt_char_linhas[1])) + 1));
        }
        if (linhas_a_serem_lidas <= linhas_totais){
            linha_stop = linhas_totais;
            linha_ini = linha_stop - linhas_a_serem_lidas;
            tac(path[0], linha_ini, linha_stop, linhas_totais);
            while (true){
                if (linha_ini - linhas_a_serem_lidas < 0){
                    linha_stop = linha_ini;
                    linha_ini = 0;
                    tac(path[0], linha_ini, linha_stop, linhas_totais);
                    break;
                } else {
                    linha_stop += -linhas_a_serem_lidas;
                    linha_ini += -linhas_a_serem_lidas;
                    tac(path[0], linha_ini, linha_stop, linhas_totais);
                }
            } 
        } else{
            if (linha_stop == 0){
                linha_stop = linhas_totais;
            } else {
                linha_ini = linhas_totais - linha_stop;
                linha_stop = linhas_totais;
            }
            tac(path[0], linha_ini, linha_stop, linhas_totais);
        }
    }
    
    public static void tac (String path, long start, long stop, long linhas_totais) throws IOException{
        LineNumberReader leitor = new LineNumberReader(new FileReader(new File(path)));
        Stack<String> lista = new Stack<>();
        while(leitor.ready()) {
            if (leitor.getLineNumber() == stop){
                leitor.close();
                break;
            } else if (leitor.getLineNumber() >= start) {
                if (leitor.getLineNumber() == linhas_totais - 1) {
                    String ultima_linha = "";
                    int temp;
                    while ((temp = leitor.read()) != -1) {
                        ultima_linha += (char)temp; 
                    }
                    lista.push(ultima_linha);
                } else {
                    lista.push(leitor.readLine() + "\n");
                }
            } else {
                leitor.readLine();
            }
        }
        while (!lista.isEmpty()) {
            System.out.print(lista.pop());
        }
    }

    public static long[] count(String path){
        try{
            LineNumberReader leitor = new LineNumberReader(new FileReader(new File(path)));
            long qt_char_linhas[] = new long[2];
            int char_atual;
            while((char_atual = leitor.read()) != -1) {
                if (char_atual == '\n') {
                    qt_char_linhas[1]++;
                }
                qt_char_linhas[0]++;
            }
            leitor.close();
            return qt_char_linhas;
        } catch (IOException e) {
            System.out.println("Não achei o arquivo");
        }
        return null;
    }
}