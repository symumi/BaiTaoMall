
package team.jmu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.jmu.bean.TType;
import team.jmu.daoImpl.AbsGoodsImpl;

/**
 * Servlet implementation class GetType
 */
@WebServlet ( "/GetType" )
public class GetType extends HttpServlet
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
		String jump = request.getParameter( "jump" );
		AbsGoodsImpl absGoodsImpl = new AbsGoodsImpl();
		List<TType> types = absGoodsImpl.GoodsType();
		request.setAttribute( "types", types );
		if( jump != null && jump.equals( "add" ) )
		{
			request.getRequestDispatcher( "/addGoods.jsp" ).forward( request,
					response );
		} else
		{
			request.getRequestDispatcher( "ShowGoods" ).forward( request,
					response );
		}

	}

}
