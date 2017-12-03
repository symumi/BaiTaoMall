
package team.jmu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.jmu.daoImpl.AbsOrderImpl;
import team.jmu.pojo.OrderDetail;

public class OperateOrderServlet extends HttpServlet
{

	public void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		request.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );

		String aid = request.getParameter( "aid" );
		String method = request.getParameter( "method" );
		OrderDetail detail = null;
		AbsOrderImpl orderImpl = new AbsOrderImpl();
		switch( method )
		{
			case "1":
				// 取消订单
				detail = orderImpl.cancelOrder( aid );
				break;
			case "2":
				// 确认收货
				detail = orderImpl.received( aid );
				break;
			case "3":
				// 确认付款
				detail = orderImpl.payOrder( aid );
				break;

		}

		request.setAttribute( "detail", detail );
		response.sendRedirect( request.getContextPath()
				+ "/servlet/ShowOrderDetail?aid=" + aid );
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{

		doGet( request, response );
	}

}
