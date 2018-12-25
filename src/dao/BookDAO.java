package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.Constant;
import connection.SQLServerConnection;
import model.Book;

public class BookDAO {
	
	public static ArrayList<Book> getBooks() throws SQLException {
		Connection conn = SQLServerConnection.getConnection(Constant.dbUrl, Constant.userName, Constant.password);
		PreparedStatement pstt = conn.prepareStatement("select * from Books");
		ResultSet rs = pstt.executeQuery();
		ArrayList<Book> listBooks = new ArrayList<>();
		while(rs.next()) {
			listBooks.add(new Book(rs.getInt("id"), rs.getString("name"), rs.getString("author"),
					rs.getString("content"), rs.getString("public_time"), rs.getInt("total")));
		}
		SQLServerConnection.closeConnection(conn);
		return listBooks;
	}
	
	public static boolean addBook(Book book) throws SQLException {
		Connection conn = SQLServerConnection.getConnection(Constant.dbUrl, Constant.userName, Constant.password);
		PreparedStatement pstt = conn.prepareStatement("insert into Books values (?, ?, ?, ?, ?)");
		pstt.setString(1, book.getName());
		pstt.setString(2, book.getAuthor());
		pstt.setString(3, book.getContent());
		pstt.setString(4, book.getPublicTime());
		pstt.setInt(5, book.getTotal());
		return (pstt.executeUpdate() > 0);
	}
	
	public static boolean deleteBook(int bookId) throws SQLException {
		Connection conn = SQLServerConnection.getConnection(Constant.dbUrl, Constant.userName, Constant.password);
		PreparedStatement pstt = conn.prepareStatement("delete from Books where id=?");
		pstt.setInt(1, bookId);
		return (pstt.executeUpdate() > 0);
	}
	
	public static boolean updateBook(Book book) throws SQLException {
		Connection conn = SQLServerConnection.getConnection(Constant.dbUrl, Constant.userName, Constant.password);
		PreparedStatement pstt = conn.prepareStatement("update Books "
				+ "set name=?, author=?, content=?, public_time=?, total=? "
				+ "where id=?");
		pstt.setString(1, book.getName());
		pstt.setString(2, book.getAuthor());
		pstt.setString(3, book.getContent());
		pstt.setString(4, book.getPublicTime());
		pstt.setInt(5, book.getTotal());
		pstt.setInt(6, book.getId());
		return (pstt.executeUpdate() > 0);
	}
}
