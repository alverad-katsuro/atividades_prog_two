package consultorio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import consultorio.classes.Cliente;
import consultorio.classes.Odontologista;

public class Atualizar_Dados {
    private Atualizar_Dados(){}

    public static boolean insertCliente(Cliente cliente){
        ConfiguracaoBD dao = new ConfiguracaoBD();
        String comando_sql = "insert into cliente (nome, idade, cpf, email, telefone, sexo, plano, endereco) values (?,?,?,?,?,?,?,?)";
        try {
            Connection con = dao.conectar();
            PreparedStatement pst = con.prepareStatement(comando_sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, Integer.toString(cliente.getIdade()));
            pst.setString(3, cliente.getCpf());
            pst.setString(4, cliente.getEmail());
            pst.setString(5, cliente.getTelefone());
            pst.setString(6, cliente.getSexo().toString());
            pst.setString(7, cliente.getPlano());
            pst.setString(8, cliente.getEnderecoComplemento());
            pst.executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    public static ArrayList<Cliente> searchClient(String option[]){
        String comando_sql;
        switch (option[0]) {
            case "*":
                comando_sql = "SELECT * FROM cliente order by nome";
                return searchClientLogical(comando_sql);
            default:
                comando_sql = "SELECT * FROM cliente WHERE "+ option[0] + " = "+ option[1];
                return searchClientLogical(comando_sql);
        }
    }

    private static ArrayList<Cliente> searchClientLogical(String comando_sql){
        ConfiguracaoBD dao = new ConfiguracaoBD();
        try {
            Connection con = dao.conectar();
            PreparedStatement pst = con.prepareStatement(comando_sql);
            ResultSet rs = pst.executeQuery();
            con.close();
            return searchClientExtract(rs);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    private static ArrayList<Cliente> searchClientExtract(ResultSet rs){
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            while (rs.next()){
                int idcleint = Integer.parseInt(rs.getString(1));
                String nome= rs.getString(2);
                int idade = Integer.parseInt(rs.getString(3));
                String cpf = rs.getString(4);
                String email = rs.getString(5);
                String telefone = rs.getString(6);
                String sexo = rs.getString(7);
                String plano = rs.getString(8);
                String endereco = rs.getString(9);
                clientes.add(new Cliente(endereco, nome, cpf, telefone, email, sexo, idade, plano, idcleint));
            }
            return clientes;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public static boolean modifyClient(Cliente cliente){
        ConfiguracaoBD dao = new ConfiguracaoBD();
        String comando_sql = "update cliente set endereco=?, nome=?, cpf=?, telefone=?, email=?, sexo=?, idade=?, plano=? where idcleint = ?";
        try {
            Connection con = dao.conectar();
            PreparedStatement pst = con.prepareStatement(comando_sql);
            pst.setString(1, cliente.getEndereco());
            pst.setString(2, cliente.getNome());
            pst.setString(3, cliente.getCpf());
            pst.setString(4, cliente.getTelefone());
            pst.setString(5, cliente.getEmail());
            pst.setString(6, cliente.getSexo().toString());
            pst.setString(7, String.valueOf(cliente.getIdade()));
            pst.setString(8, cliente.getPlano());
            pst.setString(9, String.valueOf(cliente.getIdclient()));
            pst.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static boolean insertDentista(Odontologista dentista){
        ConfiguracaoBD dao = new ConfiguracaoBD();
        String comando_sql = "insert into dentista (nome, idade, cpf, email, telefone, sexo, crm, endereco) values (?,?,?,?,?,?,?,?)";
        try {
            Connection con = dao.conectar();
            PreparedStatement pst = con.prepareStatement(comando_sql);
            pst.setString(1, dentista.getNome());
            pst.setString(2, Integer.toString(dentista.getIdade()));
            pst.setString(3, dentista.getCpf());
            pst.setString(4, dentista.getEmail());
            pst.setString(5, dentista.getTelefone());
            pst.setString(6, dentista.getSexo().toString());
            pst.setString(7, dentista.getCrm());
            pst.setString(8, dentista.getEnderecoComplemento());
            System.out.println("adsffsa");
            pst.executeUpdate();
            con.close();
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    public static ArrayList<Odontologista> searchDentista(String option[]){
        String comando_sql;
        switch (option[0]) {
            case "*":
                comando_sql = "SELECT * FROM dentista order by nome";
                return searchDentistaLogical(comando_sql);
            default:
                comando_sql = "SELECT * FROM dentista WHERE "+ option[0] + " = "+ option[1];
                return searchDentistaLogical(comando_sql);
        }
    }

    private static ArrayList<Odontologista> searchDentistaLogical(String comando_sql){
        ConfiguracaoBD dao = new ConfiguracaoBD();
        try {
            Connection con = dao.conectar();
            PreparedStatement pst = con.prepareStatement(comando_sql);
            ResultSet rs = pst.executeQuery();
            con.close();
            return searchDentistaExtract(rs);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    private static ArrayList<Odontologista> searchDentistaExtract(ResultSet rs){
        ArrayList<Odontologista> dentistas = new ArrayList<>();
        try {
            while (rs.next()){
                int iddentista = Integer.parseInt(rs.getString(1));
                String crm = rs.getString(2);
                String nome= rs.getString(3);
                int idade = Integer.parseInt(rs.getString(4));
                String cpf = rs.getString(5);
                String email = rs.getString(6);
                String telefone = rs.getString(7);
                String sexo = rs.getString(8);
                String endereco = rs.getString(9);
                String especializacao = rs.getString(10);
                dentistas.add(new Odontologista(endereco, nome, cpf, telefone, email, sexo, idade, crm, iddentista, especializacao));
            }
            return dentistas;
        } catch (SQLException e){
            System.out.println(e);
            return null;
        }
    }

    public static boolean modifyDentista(Odontologista dentista){
        ConfiguracaoBD dao = new ConfiguracaoBD();
        String comando_sql = "update cliente set endereco=?, nome=?, cpf=?, telefone=?, email=?, sexo=?, idade=?, crm=? where iddentista = ?";
        try {
            Connection con = dao.conectar();
            PreparedStatement pst = con.prepareStatement(comando_sql);
            pst.setString(1, dentista.getEndereco());
            pst.setString(2, dentista.getNome());
            pst.setString(3, dentista.getCpf());
            pst.setString(4, dentista.getTelefone());
            pst.setString(5, dentista.getEmail());
            pst.setString(6, dentista.getSexo().toString());
            pst.setString(7, String.valueOf(dentista.getIdade()));
            pst.setString(8, dentista.getCrm());
            pst.setString(9, String.valueOf(dentista.getIddentista()));
            pst.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
