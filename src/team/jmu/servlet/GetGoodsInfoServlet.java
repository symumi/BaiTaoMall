package team.jmu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.jmu.bean.TAlreadybuyGoods;
import team.jmu.bean.TGoods;
import team.jmu.daoImpl.AbsGoodsImpl;
import team.jmu.pojo.UserComment;

public class GetGoodsInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		AbsGoodsImpl abs = new AbsGoodsImpl();
		TGoods goods = new TGoods();
		List<UserComment> uclist = new ArrayList<UserComment>();
		UserComment uc;
		int gid = (Integer.parseInt(request.getParameter("gid")));
		goods = abs.findGoodsById(gid);
		List<TAlreadybuyGoods> ag = abs.findGoodsListByid(gid);
		for (int i = 0; i < ag.size(); i++) {
			uc = new UserComment(ag.get(i).getTAlreadybuyUser().getTUser()
					.getUname(), ag.get(i).getComment());
			uclist.add(uc);
		}
		request.setAttribute("goods", goods);
		request.setAttribute("uclist", uclist);
		request.getRequestDispatcher("goodsinfo.jsp")
				.forward(request, response);
	}
}
