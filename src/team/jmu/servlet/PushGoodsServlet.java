
package team.jmu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.jmu.daoImpl.AbsShoppingcartImpl;

public class PushGoodsServlet extends HttpServlet
{

	public void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		request.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );

		int uid = (int)request.getSession().getAttribute( "uid" );
		int gid = Integer.parseInt( request.getParameter( "gid" ) );

		AbsShoppingcartImpl shoppingcartImpl = new AbsShoppingcartImpl( uid );
		shoppingcartImpl.pushGoods( gid );

		request.setAttribute( "shoppingcart",
				shoppingcartImpl.getShoppingcart() );
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{

		doGet( request, response );
	}

}
