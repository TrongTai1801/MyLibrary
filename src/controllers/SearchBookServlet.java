package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Constant;
import dao.BookDAO;
import model.Book;

@WebServlet({"/searchBook"})
public class SearchBookServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		if (session.getAttribute(Constant.SESSION_USER_LOGIN_KEY) == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		
		String search = req.getParameter("search");
		
		ArrayList<Book> results = search(search);
		
		req.setAttribute(Constant.LIST_BOOK, results);
		
		req.getRequestDispatcher("/WEB-INF/views/books.jsp").forward(req, resp);
	}
	
	public ArrayList<Book> getBooks() {
		try {
			return BookDAO.getBooks();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Book> search(String search) {
		ArrayList<Book> listBooks = getBooks();
		ArrayList<Book> result = new ArrayList<>();
		result.clear();
		for (Book b : listBooks) {
			if (b.toString().contains(search)) result.add(b);
		}
		
		return result;
	}
}
