import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NewsImpleDB implements NewsInterface {

	Connection conn = null;

	public NewsImpleDB(String string) {
		String tipo = string.split(":")[1];
		if (tipo.equals("sqlite")) {
			System.out.println("Es un SQLite");
			ConectaBD(string);
		}
		if (tipo.equals("mysql")) {
			System.out.println("Es un MySQL");
			ConectaBD(string);			
		}
	}
	private ResultSet dameTabla() {
		Statement s;
		ResultSet rs = null;
		try {
			s = conn.createStatement();
			rs = s.executeQuery("select * from news");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	private void ConectaBD(String string) {
		try {
			conn = DriverManager.getConnection(string);
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
			}
		} catch (SQLException e) {
			System.out.println("Esto peta");
			System.out.println(e.getMessage());
		}
	}

	public List<New> findAll() {
		ResultSet rs = dameTabla();
		List<New> lista = new ArrayList<New>();
		try {
			while (rs.next()) {
				New n = new New();				
				n.setTitle(rs.getString("title"));
				n.setSlug(rs.getString("slug"));
				n.setDescription(rs.getString("text"));
				lista.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
}
