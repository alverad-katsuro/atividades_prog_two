package consultorio.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import consultorio.classes.Consulta;

public class AgendarConsulta {
  private AgendarConsulta(){}
  
  public static boolean agendarConsulta(Consulta consulta){
    ConfiguracaoBD dao = new ConfiguracaoBD();
    String comando_sql = "insert into consulta (especializacao, crm_dentista, cpf_cliente, diaMesAno, hora, valor, realizada) values (?,?,?,?,?,?,?)";
    try {
        Connection con = dao.conectar();
        PreparedStatement pst = con.prepareStatement(comando_sql);
        pst.setString(1, consulta.getEspecializacao().toString());
        pst.setString(2, consulta.getCrm_dentista());
        pst.setString(3, consulta.getCpf_cliente());
        pst.setString(4, consulta.getDiaMesAno());
        pst.setString(5, consulta.getHora());
        pst.setString(6, Float.toString(consulta.getValor()));
        pst.setString(7, String.valueOf(0));
        pst.executeUpdate();
        return true;
    }catch(Exception e){
        System.out.println(e);
        return false;
    }
}

    public static ArrayList<Consulta> searchConsulta(String option[]){
        String comando_sql;
        switch (option[0]) {
            case "0":
                comando_sql = "SELECT * FROM consulta order by diaMesAno";
                return searchConsultaLogical(comando_sql);
            default:
                comando_sql = "SELECT * FROM consulta WHERE diaMesAno BETWEEN " + option[0] +" and "+ option[1] +" order by diaMesAno";
                return searchConsultaLogical(comando_sql); 
        }
    }

    private static ArrayList<Consulta> searchConsultaLogical(String comando_sql){
        ConfiguracaoBD dao = new ConfiguracaoBD();
        try {
            Connection con = dao.conectar();
            PreparedStatement pst = con.prepareStatement(comando_sql);
            ResultSet rs = pst.executeQuery();
            con.close();
            return searchConsultaExtract(rs);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    private static ArrayList<Consulta> searchConsultaExtract(ResultSet rs){
        ArrayList<Consulta> consultas = new ArrayList<>();
        try {
            while (rs.next()){
                int idConsulta = Integer.parseInt(rs.getString(1));
                String especializacao= rs.getString(2);
                String crm_dentista = rs.getString(3);
                String cpf_cliente = rs.getString(4);
                String DiaMesAno[] = rs.getString(5).split("-");
                String hora = rs.getString(6);
                float valor = Float.parseFloat(rs.getString(7));
                String realizada = rs.getString(8);
                consultas.add(new Consulta(idConsulta, especializacao, crm_dentista, cpf_cliente, Integer.parseInt(DiaMesAno[2]), Integer.parseInt(DiaMesAno[1]), Integer.parseInt(DiaMesAno[0]), hora, valor, realizada));
            }
            return consultas;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static boolean modifyConsulta(Consulta consulta){
        ConfiguracaoBD dao = new ConfiguracaoBD();
        String comando_sql = "update cliente set especializacao=?, crm_dentista=?, cpf_cliente=?, diaMesAno=?, hora=?, valor=?, realizada=? where idcleint = ?";
        try {
            Connection con = dao.conectar();
            PreparedStatement pst = con.prepareStatement(comando_sql);
            pst.setString(1, consulta.getEspecializacao().toString());
            pst.setString(2, consulta.getCrm_dentista());
            pst.setString(3, consulta.getCpf_cliente());
            pst.setString(4, consulta.getDiaMesAno());
            pst.setString(5, consulta.getHora());
            pst.setString(6, Float.toString(consulta.getValor()));
            pst.setString(7, String.valueOf(consulta.getIdConsulta()));
            pst.setString(8, String.valueOf(consulta.getRealizada()));
            pst.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
