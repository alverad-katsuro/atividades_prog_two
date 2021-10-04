package consultorio.bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String user = "odonto";
	private String senha = "odonto123";
	private String url = "jdbc:mysql://138.36.20.69:10000/site_prog?useTimeZone=True&serverTimeZone=UTC";
	
	Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, senha);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
