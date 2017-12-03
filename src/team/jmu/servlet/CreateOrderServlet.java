
package team.jmu.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.jmu.bean.TAlreadybuyGoods;
import team.jmu.daoImpl.AbsOrderImpl;

public class CreateOrderServlet extends HttpServlet
{

	public void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		request.setCharacterEncoding( "UTF-8" );
		response.setContentType( "text/html;charset=UTF-8" );

		String province = request.getParameter( "province" );// 省份
		String city = request.getParameter( "city" );// 市
		String district = request.getParameter( "district" );// 区县
		String detail = request.getParameter( "detail" );// 地名
		// 拼接收货地址
		String address = province + " " + city + " " + district + " " + detail;
		System.out.println( address );

		int uid = (int)request.getSession().getAttribute( "uid" );
		String receiver = request.getParameter( "receiver" );// 收货人
		String phone = request.getParameter( "phone" );// 联系电话

		int[] gids = (int[])request.getSession().getAttribute( "gids" );
		AbsOrderImpl orderImpl = new AbsOrderImpl();

		// 测试输出数据
		/*
		System.out.println( "购买如下商品id：" );
		for( int i : gids )
		{
			System.out.print( i + "\t" );
		}
		System.out.println();
		System.out.println( uid + ":" + address + receiver + phone );
		*/

		// 创建订单
		String aid = orderImpl
				.createOrder( gids, uid, address, receiver, phone );
		ArrayList<TAlreadybuyGoods> list = new ArrayList<TAlreadybuyGoods>();

		// 控制台输出购买的商品的信息
		for( TAlreadybuyGoods tAlreadybuyGoods : list )
		{
			System.out.println( "aid=" + tAlreadybuyGoods.getId().getAid()
					+ ", gid=" + tAlreadybuyGoods.getId().getGid()
					+ ", number=" + tAlreadybuyGoods.getNumber() );
		}

		request.setAttribute( "alreadybuyGoods", list );
		response.sendRedirect( request.getContextPath()
				+ "/servlet/ShowOrderDetail?aid=" + aid );
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{

		doGet( request, response );
	}

}
