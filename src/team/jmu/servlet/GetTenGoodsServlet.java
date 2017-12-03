
package team.jmu.servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.jmu.bean.TGoods;
import team.jmu.daoImpl.AbsGoodsImpl;

/**
 * Servlet implementation class GetTenGoodsServlet
 */
@WebServlet ( "/GetTenGoodsServlet" )
public class GetTenGoodsServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet( HttpServletRequest request,
			HttpServletResponse response ) throws ServletException, IOException
	{
		doPost( request, response );
	}

	protected void doPost( HttpServletRequest request,
			HttpServletResponse response ) throws ServletException, IOException
	{
		AbsGoodsImpl absGoodsImpl = new AbsGoodsImpl();
		Set<TGoods> goods = absGoodsImpl.getTenGoods();
		request.setAttribute( "goods", goods );
		request.getRequestDispatcher( "home.jsp" ).forward( request, response );
	}

}
