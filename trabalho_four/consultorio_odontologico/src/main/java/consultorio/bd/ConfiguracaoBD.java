package consultorio.bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConfiguracaoBD {
	private final String driver = "com.mysql.cj.jdbc.Driver";
	private final String user = "odonto";
	private final String senha = "odonto123";
	private final String url = "jdbc:mysql://138.36.20.69:10000/site_prog?useTimeZone=True&serverTimeZone=UTC";
	
	public Connection conectar() {
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
