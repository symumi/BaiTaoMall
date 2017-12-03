
package team.jmu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import team.jmu.bean.SProvince;
import team.jmu.bean.SProvinceDAO;

public class ProvinceServlet extends HttpServlet
{

	public void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		response.setContentType( "text/html;charset=utf-8" );
		request.setCharacterEncoding( "utf-8" );
		try
		{
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"applicationContext.xml" );
			SProvinceDAO dao = (SProvinceDAO)context.getBean( "SProvinceDAO" );
			List<SProvince> list = dao.findAll();
			StringBuffer sb = new StringBuffer();
			for( int i = 0; i < list.size(); i++ )
			{
				SProvince province = list.get( i );
				sb.append( province.getProvinceName() );
				if( i != list.size() - 1 )
				{
					sb.append( "," );
				}
			}
			response.getWriter().print( sb );
		} catch( Exception e )
		{
			throw new RuntimeException( e );
		}

	}

	public void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{

		doGet( request, response );
	}

}
