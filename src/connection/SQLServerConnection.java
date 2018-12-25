package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnection {
	public static Connection getConnection(String dbUrl, String userName, String password) {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(dbUrl, userName, password);
			System.out.println("Connect successfully!");
		} catch (Exception e) {
			System.out.println("Connect failure!");
			e.printStackTrace();
		}
		return conn;
	}	
	
	public static void closeConnection(Connection conn) throws SQLException {
		if (conn != null) conn.close();
	}
}
