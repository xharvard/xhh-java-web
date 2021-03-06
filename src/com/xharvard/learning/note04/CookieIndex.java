package com.xharvard.learning.note04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie-index")
public class CookieIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CookieIndex() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				String value = cookie.getValue();
				
				if("xhh".equals(name) && "123456".equals(value)){
					request.setAttribute("user", name);
					request.getRequestDispatcher("view-cookie.do").forward(request, response);
					return;
				}
			}
		}
		
		response.sendRedirect("html/note04/login.html");

	}

}
