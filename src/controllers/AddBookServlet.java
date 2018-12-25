package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Constant;
import dao.BookDAO;
import model.Book;

@WebServlet({"/addBook"})
public class AddBookServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute(Constant.SESSION_USER_LOGIN_KEY) == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		
		req.getRequestDispatcher("/WEB-INF/views/addBook.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name = req.getParameter("name");
			String author = req.getParameter("author");
			String content = req.getParameter("content");
			String publicTime = req.getParameter("public_time");
			int total = Integer.parseInt(req.getParameter("total"));
			if (BookDAO.addBook(new Book(0, name, author, content, publicTime, total))) resp.sendRedirect(req.getContextPath() + "/books");
			else resp.sendRedirect(req.getContextPath() + "/addBook");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
