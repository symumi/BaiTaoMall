
package team.jmu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.jmu.daoImpl.AbsOrderImpl;

public class ConfirmOrderServlet extends HttpServlet
{

	public void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		request.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );

		int[] gids = str2int( request.getParameterValues( "gid" ) );
		request.getSession().setAttribute( "gids", gids );
		String number = request.getParameter( "number" );
		int uid = (int)request.getSession().getAttribute( "uid" );
		AbsOrderImpl orderImpl = new AbsOrderImpl();
		if( number != null )
		{
			request.setAttribute(
					"info",
					orderImpl.getConfirmOrderInfo( gids, uid,
							Integer.parseInt( number ) ) );
		} else
		{
			request.setAttribute( "info",
					orderImpl.getConfirmOrderInfo( gids, uid, 0 ) );
		}

		request.getRequestDispatcher( "/WEB-INF/page/confirmOrder.jsp" )
				.forward( request, response );
	}

	private int[] str2int( String[] strings )
	{
		int[] result = new int[strings.length];
		for( int i = 0; i < strings.length; i++ )
		{
			result[i] = Integer.parseInt( strings[i] );
		}
		return result;
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{

		doGet( request, response );
	}

}
