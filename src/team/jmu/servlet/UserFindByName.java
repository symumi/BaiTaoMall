package team.jmu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.jmu.bean.TUser;
import team.jmu.bean.TUserDAO;
import team.jmu.daoImpl.AbsUersImpl;

public class UserFindByName extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username").trim();
		AbsUersImpl abs = new AbsUersImpl();
		if (abs.findUserByName(username)) {
			response.getWriter().print("true");
		} else
			response.getWriter().print("false");
	}

}
