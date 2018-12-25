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

@WebServlet("/books")
public class BooksServlet extends HttpServlet {
	
	private ArrayList<Book> listBook = new ArrayList<>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute(Constant.SESSION_USER_LOGIN_KEY) == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		
		try {
			listBook.clear();
			listBook.addAll(BookDAO.getBooks());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute(Constant.LIST_BOOK, listBook);
		
		req.getRequestDispatcher("/WEB-INF/views/books.jsp").forward(req, resp);
	}
}
