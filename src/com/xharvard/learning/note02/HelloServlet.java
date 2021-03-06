package com.xharvard.learning.note02;

import com.xharvard.learning.constant.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello.view")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(Constant.CONTENT_TYPE);

		PrintWriter pw = response.getWriter();
		String name = request.getParameter("name");

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Hello Servlet</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1> Hello! " + name + "</h1>");
		pw.println("<p>对于同一个servlet,在web.xml中配置后会覆盖注解的配置。</p>");
		pw.println("</body>");
		pw.println("</html>");

		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
