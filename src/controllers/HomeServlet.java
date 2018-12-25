package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Constant;

@WebServlet({"/", "/home"})
public class HomeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute(Constant.SESSION_USER_LOGIN_KEY) == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
	}

}
