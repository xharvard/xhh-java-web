package com.xharvard.learning.goosip.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xharvard.learning.constant.Constant;

@WebServlet("/login.done")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String USERS = "E:\\xhh_work\\07_jsp\\workspace\\web_introduction\\Gossip\\users";
	private final String SUCCESS_VIEW = "member.view";
	private final String ERROR_VIEW = "html/gossip/index.html";

	public Login() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType(Constant.CONTENT_TYPE);

		// 取得请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (checkLogin(username, password)) {
			// 保持用户登录信息
			request.getSession().setAttribute("login", username);
			request.getRequestDispatcher(SUCCESS_VIEW).forward(request, response);
		} else {
			response.sendRedirect(ERROR_VIEW);
		}

	}

	/**
	 * 判断用户是否存在
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws IOException
	 */
	private boolean checkLogin(String username, String password) throws IOException {
		if (username != null && password != null) {
			for (String file : new File(USERS).list()) {
				if (file.equals(username)) {
					BufferedReader reader = new BufferedReader(new FileReader(USERS + "/" + file + "/profile"));
					String passwd = reader.readLine().split("\t")[1];

					if (passwd.equals(password)) {
						reader.close();
						return true;
					}
					reader.close();
				}
			}
		}

		return false;
	}

}
