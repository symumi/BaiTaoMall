package team.jmu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.getSession().removeAttribute("lf");
		request.getSession().removeAttribute("uid");
		request.getSession().removeAttribute("lastlogintime");
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("username");
		request.getSession().removeAttribute("email");
		request.getRequestDispatcher("GetTenGoodsServlet").forward(request, response);
	}

}
