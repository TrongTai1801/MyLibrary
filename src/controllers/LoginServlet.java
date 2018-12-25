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
import dao.AccountDAO;
import model.Account;

@WebServlet({"/login"})
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute(Constant.SESSION_USER_LOGIN_KEY, null);
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		
		try {
			Account account = AccountDAO.getAcount(userName, password);
			
			if (account != null) {
				//save user to session
				HttpSession session = req.getSession();
				session.setAttribute(Constant.SESSION_USER_LOGIN_KEY, account);
				
				resp.sendRedirect(req.getContextPath() + "/home");
			} else {
				req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
