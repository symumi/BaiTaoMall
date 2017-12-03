package team.jmu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.jmu.bean.TGoods;
import team.jmu.daoImpl.AbsGoodsImpl;
import team.jmu.pojo.ListNum;

/**
 * Servlet implementation class ShowGoods
 */
@WebServlet("/ShowGoods")
public class ShowGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowGoods() {
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
		AbsGoodsImpl absGoodsImpl = new AbsGoodsImpl();
		List<TGoods> goods = absGoodsImpl.findAll();
		
	    ListNum num = new ListNum(goods.size(),4);
		request.setAttribute("num", num);
		request.setAttribute("goods", goods);
		request.getRequestDispatcher("showGoods.jsp").forward(request, response);
	}

}
