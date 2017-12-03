
package team.jmu.test;

import java.util.Date;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServlet;

import org.junit.Test;

import team.jmu.bean.TGoods;
import team.jmu.daoImpl.AbsShoppingcartImpl;

public class TestShoppingcart extends HttpServlet
{
	@Test
	public void random()
	{
		Random random = new Random( new Date().getTime() );

		System.out.println( random.nextInt() );
	}

	@Test
	public void testPut()
	{
		int uid = 1, gid = 1;
		AbsShoppingcartImpl shoppingcartImpl = new AbsShoppingcartImpl( uid );
		shoppingcartImpl.putGoods( gid, 10 );
		Map<TGoods, Integer> shoppingcartMap = shoppingcartImpl
				.getShoppingcart();

		show( shoppingcartMap, uid );
	}

	@Test
	public void testChangeNumber()
	{
		int uid = 1, gid = 1;
		int newnum = 66;
		AbsShoppingcartImpl shoppingcartImpl = new AbsShoppingcartImpl( uid );
		shoppingcartImpl.changeNumber( gid, newnum );

		Map<TGoods, Integer> shoppingcartMap = shoppingcartImpl
				.getShoppingcart();

		show( shoppingcartMap, uid );
	}

	@Test
	public void testPush()
	{
		int uid = 1, gid = 1;
		AbsShoppingcartImpl shoppingcartImpl = new AbsShoppingcartImpl( uid );
		shoppingcartImpl.pushGoods( gid );

		Map<TGoods, Integer> shoppingcartMap = shoppingcartImpl
				.getShoppingcart();

		show( shoppingcartMap, uid );
	}

	private void show( Map<TGoods, Integer> shoppingcartMap, int uid )
	{
		System.out.println( "uid=" + uid + "的购物车有如下商品:" );
		for( TGoods goods : shoppingcartMap.keySet() )
		{
			System.out.println( goods.getGname() + "的数量为"
					+ shoppingcartMap.get( goods ) );
		}
	}
}
