
package team.jmu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.jmu.daoImpl.AbsOrderImpl;

public class SendGoodsServlet extends HttpServlet
{

	public void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		request.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );

		String aid = request.getParameter( "aid" );
		String carriage = request.getParameter( "carriage" );

		AbsOrderImpl orderImpl = new AbsOrderImpl();
		orderImpl.sendGoods( aid, carriage );

		response.sendRedirect( request.getContextPath()
				+ "/servlet/GetAllOrder" );
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{

		doGet( request, response );
	}

}
