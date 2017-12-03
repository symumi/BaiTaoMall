
package team.jmu.dao;

import java.util.HashSet;
import java.util.List;

import team.jmu.bean.TAlreadybuyGoods;
import team.jmu.bean.TGoods;
import team.jmu.bean.TType;

public abstract class AbsGoods
{
	// 获取全部
	public abstract List<TGoods> findAll();

	// 添加新的物品
	public abstract boolean createGoods( TGoods goods, int tid );;

	// 更改商品
	public abstract void updateGoods( TGoods goods, int tid );

	// 通过名字查找
	public abstract List<TGoods> findGoodsByName( String gname );

	// 通过类型查找
	public abstract List<TGoods> findGoodsByType( int tid );

	// 获取类型
	public abstract List<TType> GoodsType();

	// 删除商品
	public abstract void deleteGoods( int gid );

	// 获取某个特定商品
	public abstract TGoods getTheGoods( int gid );

	// 随机获取十个商品
	public abstract HashSet<TGoods> getTenGoods();

	// 通过查找商品
	public abstract TGoods findGoodsById( int gid );
	
	public abstract List<TAlreadybuyGoods> findGoodsListByid(int gid);
}
