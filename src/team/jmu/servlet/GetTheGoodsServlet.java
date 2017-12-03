package team.jmu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.jmu.bean.TGoods;
import team.jmu.bean.TType;
import team.jmu.daoImpl.AbsGoodsImpl;

/**
 * Servlet implementation class GetTheGoodsServlet
 */
@WebServlet("/GetTheGoodsServlet")
public class GetTheGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTheGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		 AbsGoodsImpl absGoodsImpl = new AbsGoodsImpl();
		 List<TType> types = absGoodsImpl.GoodsType();
		 request.setAttribute("types", types);
		 TGoods goods = absGoodsImpl.getTheGoods(goodsId);
		 request.setAttribute("goods", goods);
		 request.getRequestDispatcher("/updateGoods.jsp").forward(request, response);
	}

}
