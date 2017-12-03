package team.jmu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.jmu.bean.TUser;
import team.jmu.daoImpl.AbsUersImpl;

public class SignServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		TUser user = new TUser();
		AbsUersImpl abs = new AbsUersImpl();
		String repeatpassword = request.getParameter("repeatpassword");
		user.setUname(request.getParameter("username").trim());
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		if (repeatpassword.equals(user.getPassword())) {
			if (abs.sign(user))
				request.getRequestDispatcher("home.jsp").forward(request,
						response);
			else
				request.getRequestDispatcher("sign.jsp").forward(request,
						response);
		} else {
			request.getRequestDispatcher("sign.jsp").forward(request, response);
		}

	}
}
