
package team.jmu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.jmu.daoImpl.AbsOrderImpl;
import team.jmu.pojo.OrderDetail;

public class ShowOrderDetailServlet extends HttpServlet
{

	public void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		request.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );

		String aid = request.getParameter( "aid" );
		AbsOrderImpl orderImpl = new AbsOrderImpl();
		OrderDetail detail = orderImpl.getOrderDetail( aid );

		request.setAttribute( "detail", detail );
		request.getRequestDispatcher( "/WEB-INF/page/showOrderDetail.jsp" )
				.forward( request, response );
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{

		doGet( request, response );
	}

}
