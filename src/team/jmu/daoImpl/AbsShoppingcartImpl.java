
package team.jmu.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import team.jmu.bean.TGoods;
import team.jmu.bean.TGoodsDAO;
import team.jmu.bean.TShoppingcart;
import team.jmu.bean.TShoppingcartDAO;
import team.jmu.bean.TUser;
import team.jmu.bean.TUserDAO;
import team.jmu.dao.AbsShoppingcart;

public class AbsShoppingcartImpl extends AbsShoppingcart
{
	private static ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml" );
	private static TShoppingcartDAO tShoppingcartDAO = (TShoppingcartDAO)context
			.getBean( "TShoppingcartDAO" );
	private static TGoodsDAO tGoodsDAO = (TGoodsDAO)context
			.getBean( "TGoodsDAO" );
	private static TUserDAO tUserDAO = (TUserDAO)context.getBean( "TUserDAO" );

	public AbsShoppingcartImpl( int uid )
	{
		this.uid = uid;
		join();
	}

	// 添加数据库中的购物车数据到shoppingcartMap
	@Override
	protected void join()
	{
		for( TShoppingcart shoppingcart : (List<TShoppingcart>)tShoppingcartDAO
				.findAll() )
		{
			if( shoppingcart.getTUser().getUid() == uid )
			{
				shoppingcartMap.put( shoppingcart.getTGoods(),
						shoppingcart.getNumber() );
			}
		}
	}

	@Override
	public void putGoods( int gid, int num )
	{
		long newnum;
		TUser user = tUserDAO.findById( uid );
		TGoods goods = tGoodsDAO.findById( gid );
		TShoppingcart shoppingcart = tShoppingcartDAO.findByUidGid( uid, gid );
		// 判断该商品是否存在于购物车
		if( shoppingcartMap.containsKey( goods ) )
		{
			// 存在该商品
			shoppingcart = tShoppingcartDAO.findByUidGid( uid, gid );
			// 加入购物车后小于库存
			Long max = tGoodsDAO.findById( gid ).getNumber();
			if( (num + shoppingcart.getNumber()) <= max )
			{
				newnum = shoppingcart.getNumber() + num;
			} else
			{
				newnum = max;
			}
			shoppingcart.setNumber( (int)newnum );
			// 添加该购物车到数据库中
			tShoppingcartDAO.attachDirty( shoppingcart );
		} else
		{
			// 不存在该商品
			shoppingcart = new TShoppingcart();
			newnum = num;
			shoppingcart.setTGoods( goods );
			shoppingcart.setTUser( user );
			shoppingcart.setNumber( (int)newnum );
			tShoppingcartDAO.save( shoppingcart );
		}
		shoppingcartMap.put( goods, (int)newnum );
	}

	@Override
	public boolean pushGoods( int gid )
	{
		boolean flag = false;
		TGoods goods = tGoodsDAO.findById( gid );
		if( shoppingcartMap.containsKey( goods ) )
		{
			shoppingcartMap.remove( goods );

			// 从数据库中删除
			tShoppingcartDAO.delete( tShoppingcartDAO.findByUidGid( uid, gid ) );
			flag = true;
		}

		return flag;
	}

	@Override
	public boolean changeNumber( int gid, int newnum )
	{
		boolean flag = false;
		for( TShoppingcart shoppingcart : findByUid() )
		{
			TGoods goods = shoppingcart.getTGoods();
			if( goods.getGid() == gid )
			{
				shoppingcart.setNumber( newnum );
				tShoppingcartDAO.attachDirty( shoppingcart );
				shoppingcartMap.put( goods, newnum );
				flag = true;
				break;
			}
		}
		return flag;
	}

	// 根据uid查找TShoppingcart
	private List<TShoppingcart> findByUid()
	{
		List<TShoppingcart> result = new ArrayList<TShoppingcart>();
		for( TShoppingcart shoppingcart : (List<TShoppingcart>)tShoppingcartDAO
				.findAll() )
		{
			if( shoppingcart.getTUser().getUid() == uid )
			{
				result.add( shoppingcart );
			}
		}
		return result;
	}

}
