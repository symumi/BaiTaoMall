
package team.jmu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import team.jmu.bean.SCity;
import team.jmu.bean.SCityDAO;
import team.jmu.bean.SProvince;
import team.jmu.bean.SProvinceDAO;

public class CityServlet extends HttpServlet
{

	public void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		response.setContentType( "text/html;charset=utf-8" );
		request.setCharacterEncoding( "utf-8" );

		String provinceName = request.getParameter( "provinceName" );
		try
		{
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"applicationContext.xml" );
			SProvinceDAO provinceDao = (SProvinceDAO)context
					.getBean( "SProvinceDAO" );
			SProvince province = (SProvince)provinceDao.findByProvinceName(
					provinceName ).get( 0 );
			SCityDAO cityDao = (SCityDAO)context.getBean( "SCityDAO" );
			List<SCity> list = cityDao.findByProvinceId( province
					.getProvinceId() );
			StringBuffer sb = new StringBuffer();
			for( int i = 0; i < list.size(); i++ )
			{
				SCity city = list.get( i );
				sb.append( city.getCityName() );
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
