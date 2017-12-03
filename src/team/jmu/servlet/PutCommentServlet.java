
package team.jmu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.jmu.daoImpl.AbsOrderImpl;

public class PutCommentServlet extends HttpServlet
{

	public void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		request.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );

		String aid = request.getParameter( "aid" );
		int gid = Integer.parseInt( request.getParameter( "gid" ) );
		String comment = request.getParameter( "comment" );
		System.out.println( comment );

		AbsOrderImpl orderImpl = new AbsOrderImpl();
		orderImpl.putComment( aid, gid, comment );

		response.sendRedirect( request.getContextPath()+"/servlet/ShowOrderDetail?aid=" + aid );
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{

		doGet( request, response );
	}

}
