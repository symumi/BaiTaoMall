
package team.jmu.dao;

import java.util.LinkedHashMap;
import java.util.Map;

import team.jmu.bean.TGoods;

public abstract class AbsShoppingcart
{
	protected Map<TGoods, Integer> shoppingcartMap = new LinkedHashMap<TGoods, Integer>();
	protected int uid;

	// 读入数据库的购物车商品
	protected abstract void join();

	// 添加商品
	public abstract void putGoods( int gid, int num );

	// 删除商品
	public abstract boolean pushGoods( int gid );

	// 修改商品数量
	public abstract boolean changeNumber( int gid, int newnum );

	public Map<TGoods, Integer> getShoppingcart()
	{
		return shoppingcartMap;
	}

}
