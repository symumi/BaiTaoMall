
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
import team.jmu.bean.SDistrict;
import team.jmu.bean.SDistrictDAO;

public class DistrictServlet extends HttpServlet
{

	public void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		response.setContentType( "text/html;charset=utf-8" );
		request.setCharacterEncoding( "utf-8" );

		String cityName = request.getParameter( "cityName" );
		try
		{
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"applicationContext.xml" );
			SCityDAO cityDao = (SCityDAO)context.getBean( "SCityDAO" );
			SCity city = (SCity)cityDao.findByCityName( cityName ).get( 0 );
			SDistrictDAO districtDao = (SDistrictDAO)context
					.getBean( "SDistrictDAO" );
			List<SDistrict> list = districtDao.findByCityId( city.getCityId() );
			StringBuffer sb = new StringBuffer();
			for( int i = 0; i < list.size(); i++ )
			{
				SDistrict district = list.get( i );
				sb.append( district.getDistrictName() );
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
