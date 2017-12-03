
package team.jmu.test;

import org.junit.Test;

import team.jmu.dao.AbsOrder;
import team.jmu.daoImpl.AbsOrderImpl;

public class TestAbsOrderImpl
{
	@Test
	public void testCreateOrder()
	{
		for( int i = 0; i < 10; i++ )
		{
			AbsOrder absOrder = new AbsOrderImpl();
			int[] gids = {1, 2};
			absOrder.createOrder( gids, 1, null, null, null );
			try
			{
				Thread.sleep( 10 );
			} catch( Exception e )
			{
				System.exit( 0 );// 退出程序
			}
		}
	}
}
