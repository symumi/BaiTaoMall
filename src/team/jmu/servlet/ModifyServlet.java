package team.jmu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.jmu.bean.TUser;
import team.jmu.daoImpl.AbsUersImpl;

public class ModifyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		TUser user=new TUser();
		AbsUersImpl abs=new AbsUersImpl();
		user.setUid((int)request.getSession().getAttribute("uid"));
		System.out.println(user.getUid());
		user.setUname(request.getSession().getAttribute("username").toString());
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		abs.modify(user);
		request.getRequestDispatcher("GetTenGoodsServlet").forward(request, response);
	}

}
