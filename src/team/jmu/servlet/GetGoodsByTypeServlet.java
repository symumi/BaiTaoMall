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
import team.jmu.pojo.ListNum;

/**
 * Servlet implementation class GetGoodsByType
 */
@WebServlet("/GetGoodsByType")
public class GetGoodsByTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetGoodsByTypeServlet() {
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
		int tid = Integer.parseInt( request.getParameter("tid"));
		AbsGoodsImpl goodsImpl = new AbsGoodsImpl();
		List<TGoods> goods = goodsImpl.findGoodsByType(tid);
		List<TType> types = goodsImpl.GoodsType();
		ListNum num = new ListNum(goods.size(),4);
		request.setAttribute("num", num);
		request.setAttribute("goods", goods);
		request.setAttribute("types", types);
		request.getRequestDispatcher("store.jsp").forward(request, response);
	}

}
