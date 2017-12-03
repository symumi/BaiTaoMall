
package team.jmu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.jmu.daoImpl.AbsShoppingcartImpl;

public class ShowShoppingcartServlet extends HttpServlet
{

	public void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		request.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );

		int uid = (int)request.getSession().getAttribute( "uid" );
		AbsShoppingcartImpl shoppingcartImpl = new AbsShoppingcartImpl( uid );

		request.getSession().setAttribute( "shoppingcart",
				shoppingcartImpl.getShoppingcart() );
		request.getRequestDispatcher( "/WEB-INF/page/shoppingcart.jsp" )
				.forward( request, response );
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{

		doGet( request, response );
	}

}
