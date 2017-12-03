
package team.jmu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.jmu.bean.TUser;
import team.jmu.daoImpl.AbsOrderImpl;
import team.jmu.daoImpl.AbsUersImpl;
import team.jmu.pojo.OrderDetail;

public class GetAllOrderServlet extends HttpServlet
{

	public void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		request.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );

		AbsUersImpl userImpl = new AbsUersImpl();
		List<TUser> users = userImpl.getAllUsers();
		List<OrderDetail> details = new ArrayList<OrderDetail>();
		String statusString = request.getParameter( "status" );

		if( statusString != null )
		{
			for( TUser tUser : users )
			{
				AbsOrderImpl orderImpl = new AbsOrderImpl();
				List<String> aids = orderImpl.getOrderAids( tUser.getUid() );

				for( String aid : aids )
				{
					details.add( orderImpl.getOrderDetail( aid ) );
				}
			}
		} else
		{
			for( TUser tUser : users )
			{
				AbsOrderImpl orderImpl = new AbsOrderImpl();
				List<String> aids = orderImpl.getOrderAids( tUser.getUid() );

				for( String aid : aids )
				{
					OrderDetail detail = orderImpl.getOrderDetail( aid );
					if( detail.getSendtime() == null )
						details.add( detail );
				}
			}
		}
		request.setAttribute( "details", details );
		request.getRequestDispatcher( "/WEB-INF/page/getAllOrder.jsp" )
				.forward( request, response );

	}

	public void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{

		doGet( request, response );
	}

}
