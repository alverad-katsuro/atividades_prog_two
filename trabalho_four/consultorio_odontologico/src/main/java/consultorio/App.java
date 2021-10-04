package consultorio;

import consultorio.classes.*;

import java.util.ArrayList;
import java.util.Scanner;

import consultorio.bd.*;

public class App {
    private final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        /*
        Cliente cliente = new Cliente("Alfredooo", "097.972.852-27", "(91) 98448-7808", "amgabriel1@hotmail.com", "masculino", 21000, "Brasil", "Pará", "Barcarena", "São Francisco", "Rua do Ancoradouro", "228", "Ao lado da Lê Modas", "Basic");
        Atualizar_Dados.insertCliente(cliente);
        ArrayList<Cliente> clientes = Atualizar_Dados.readClient();
        Cliente.describe(clientes.get(2));
        */
        String data[] = {"2000-01-01", "2015-05-05"};
        ArrayList<Consulta> consulta = AgendarConsulta.searchConsulta(data);
        System.out.println(consulta.get(0));
    }
}
