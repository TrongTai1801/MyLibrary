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

@WebServlet({"/editBook"})
public class EditBookServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute(Constant.SESSION_USER_LOGIN_KEY) == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		System.out.println(req.getParameter("bookId"));
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		Book book = getBook(bookId);
		req.setAttribute(Constant.BOOK, book);
		req.getRequestDispatcher("/WEB-INF/views/editBook.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int bookId = Integer.parseInt(req.getParameter(Constant.BOOK_ID));
			String name = req.getParameter(Constant.NAME);
			String author = req.getParameter(Constant.AUTHOR);
			String content = req.getParameter(Constant.CONTENT);
			String publicTime = req.getParameter(Constant.PUBLIC_TIME);
			int total = Integer.parseInt(req.getParameter(Constant.TOTAL));
			Book book = new Book(bookId, name, author, content, publicTime, total);
			if (BookDAO.updateBook(book)) resp.sendRedirect(req.getContextPath() + "/books");
			else {
				req.setAttribute(Constant.BOOK, book);
				req.getRequestDispatcher("/WEB-INF/views/editBook.jsp").forward(req, resp);//resp.sendRedirect(req.getContextPath() + "/addBook");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Book getBook(int bookId) {
		try {
			ArrayList<Book> listBook = BookDAO.getBooks();
			for (Book b : listBook) {
				if (b.getId() == bookId) return b;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
