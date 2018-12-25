package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.Constant;
import connection.SQLServerConnection;
import model.Account;

public class AccountDAO {
	public static Account getAcount(String userName, String password) throws SQLException {
		Connection conn = SQLServerConnection.getConnection(Constant.dbUrl, Constant.userName, Constant.password);
		PreparedStatement pstt = conn.prepareStatement("select * from Account where userName=? and password=?");
		pstt.setString(1, userName);
		pstt.setString(2, password);
		ResultSet rs = pstt.executeQuery();
		while(rs.next()) {
			return new Account(rs.getInt("id"), rs.getString("userName"), rs.getString("password"));
		}
		SQLServerConnection.closeConnection(conn);
		return null;
	}
}
