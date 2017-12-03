package team.jmu.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.jmu.bean.TUser;
import team.jmu.daoImpl.AbsUersImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		TUser user = new TUser();
		TUser u = new TUser();
		AbsUersImpl abs = new AbsUersImpl();
		user.setUname(request.getParameter("username").trim());
		user.setPassword(request.getParameter("password").trim());
		u = abs.login(user);
		if (u != null && user.getUname().equals("admini")
				&& user.getPassword().equals("admini"))
			response.sendRedirect("GetType");
		else if (u != null && u.getPassword().equals(user.getPassword())) {
			u.setLastlogin(new Timestamp(new Date().getTime()));
			abs.setLastLogin(u);
			request.getSession().setAttribute(
					"lastlogintime",
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(u
							.getLastlogin()));
			request.getSession().setAttribute("user", u);
			request.getSession().setAttribute("uid", u.getUid());
			request.getSession().setAttribute("username", u.getUname());
			request.getSession().setAttribute("email", u.getEmail());
			request.getSession().setAttribute("lf", 1);
			request.getRequestDispatcher("GetTenGoodsServlet").forward(request,
					response);
		} else
			request.getRequestDispatcher("loginfail.jsp").forward(request,
					response);
	}

}
