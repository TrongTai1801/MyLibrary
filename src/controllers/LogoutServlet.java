package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Constant;


@WebServlet({"/logout"})
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		if (session.getAttribute(Constant.SESSION_USER_LOGIN_KEY) == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		
		session.setAttribute(Constant.SESSION_USER_LOGIN_KEY, null);
		resp.sendRedirect(req.getContextPath() + "/login");
	}
}
