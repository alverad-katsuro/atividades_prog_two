package consultorio.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import consultorio.bd.ConfiguracaoBD;
import consultorio.classes.Enum.Funcao;

public class Contas {
    private Funcao funcao;

    public Contas(String usuario, String senha){
        ConfiguracaoBD dao = new ConfiguracaoBD();
        String comando_sql = "SELECT * FROM contas WHERE login = ? and senha = ?";
        try {
            Connection con = dao.conectar();
            PreparedStatement pst = con.prepareStatement(comando_sql);
            pst.setString(1, usuario.strip());
            pst.setString(2, senha.strip());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                this.funcao = comparaFuncao(rs.getString(4));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public Funcao getFuncao() {
        return funcao;
    }
    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public static Funcao comparaFuncao(String funcao){
        switch (funcao.toUpperCase()) {
            case "ATENDENTE":
                return Funcao.ATENDENTE;
            case "DENTISTA":
                return Funcao.DENTISTA;
        }
        return null;
    }
}
