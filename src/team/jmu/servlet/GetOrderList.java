
package team.jmu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.jmu.daoImpl.AbsOrderImpl;
import team.jmu.pojo.OrderDetail;

public class GetOrderList extends HttpServlet
{

	public void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		request.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );

		int uid = (int)request.getSession().getAttribute( "uid" );
		AbsOrderImpl orderImpl = new AbsOrderImpl();
		List<String> aids = orderImpl.getOrderAids( uid );
		List<OrderDetail> details = new ArrayList<OrderDetail>();
		for( String aid : aids )
		{
			details.add( orderImpl.getOrderDetail( aid ) );
		}
		request.setAttribute( "details", details );
		request.getRequestDispatcher( "/WEB-INF/page/getOrderList.jsp" )
				.forward( request, response );
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{

		doGet( request, response );
	}

}
