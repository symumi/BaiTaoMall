
package team.jmu.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import team.jmu.bean.TGoods;
import team.jmu.pojo.OrderDetail;

public abstract class AbsOrder
{
	// 获得确认订单信息
	public abstract Map<TGoods, Integer> getConfirmOrderInfo( int[] gids,
			int uid, int num );

	// 产生订单
	public abstract String createOrder( int[] gids, Integer uid,
			String address, String receiver, String phone );

	// 取消订单
	public abstract OrderDetail cancelOrder( String aid );

	// 确认发货
	public abstract Timestamp sendGoods( String aid, String carriage );

	// 确认收货
	public abstract OrderDetail received( String aid );

	// 确认付款
	public abstract OrderDetail payOrder( String aid );

	// 根据aid,uid获取订单详细信息
	public abstract OrderDetail getOrderDetail( String aid );

	// 评价商品
	public abstract void putComment( String aid, int gid, String comment );

	// 获得uid下的所有订单号aid
	public abstract List<String> getOrderAids( int uid );

}
