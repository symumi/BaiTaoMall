package team.jmu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.jmu.bean.TGoods;
import team.jmu.daoImpl.AbsGoodsImpl;

/**
 * Servlet implementation class UpdateGoodsServlet
 */
@WebServlet("/UpdateGoodsServlet")
public class UpdateGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateGoodsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int gid = Integer.parseInt(request.getParameter("gid"));
		AbsGoodsImpl absGoodsImpl = new AbsGoodsImpl();
		TGoods good = absGoodsImpl.getTheGoods(gid);
		String imgPath = good.getGphoto();
		if (request.getSession().getAttribute("imgPath") != null) {
			imgPath = (String) request.getSession().getAttribute("imgPath");
			String img = null;
			request.getSession().setAttribute("imgPath", img);
		}

		TGoods goods = new TGoods();
		int sid = 1;
		String gname = request.getParameter("gname");
		String note = request.getParameter("note");
		double price = Double.parseDouble(request.getParameter("price"));
		Long number = Long.parseLong(request.getParameter("number"));
		int tid = Integer.parseInt(request.getParameter("type"));

		if (!gname.equals("") && gname != null) {
			if (number > 0 && price > 0 && tid > 0) {
				goods.setGid(gid);
				goods.setGname(gname);
				if (!imgPath.equals(""))
					goods.setGphoto(imgPath);
				goods.setNumber(number);
				goods.setPrice(price);
				goods.setNote(note);
				goods.setSid(sid);
				goods.setIsExist(true);
				absGoodsImpl.updateGoods(goods, tid);
				response.sendRedirect("/shopping/GetType");
			}
		} else {
			response.sendRedirect("servlet/GetTheGoodsServlet?goodsId=" + gid
					+ "");
		}
	}

}
