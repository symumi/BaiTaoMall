package team.jmu.daoImpl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import team.jmu.bean.TAlreadybuyGoods;
import team.jmu.bean.TAlreadybuyGoodsDAO;
import team.jmu.bean.TAlreadybuyGoodsId;
import team.jmu.bean.TAlreadybuyUser;
import team.jmu.bean.TAlreadybuyUserDAO;
import team.jmu.bean.TGoods;
import team.jmu.bean.TGoodsDAO;
import team.jmu.bean.TShoppingcart;
import team.jmu.bean.TShoppingcartDAO;
import team.jmu.bean.TUser;
import team.jmu.bean.TUserDAO;
import team.jmu.dao.AbsOrder;
import team.jmu.pojo.OrderDetail;

public class AbsOrderImpl extends AbsOrder {

	private static ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	private static TShoppingcartDAO tShoppingcartDAO = (TShoppingcartDAO) context
			.getBean("TShoppingcartDAO");
	private static TGoodsDAO tGoodsDAO = (TGoodsDAO) context
			.getBean("TGoodsDAO");
	private static TUserDAO tUserDAO = (TUserDAO) context.getBean("TUserDAO");
	private static TAlreadybuyGoodsDAO tAlreadybuyGoodsDAO = (TAlreadybuyGoodsDAO) context
			.getBean("TAlreadybuyGoodsDAO");
	private static TAlreadybuyUserDAO tAlreadybuyUserDAO = (TAlreadybuyUserDAO) context
			.getBean("TAlreadybuyUserDAO");

	@Override
	/**
	 * 根据gid,数量num和uid获取确认订单的详细信息
	 * 
	 */
	public Map<TGoods, Integer> getConfirmOrderInfo(int[] gids, int uid, int num) {
		Map<TGoods, Integer> infoMap = new LinkedHashMap<TGoods, Integer>();
		if (num != 0) {
			// num不为0，从商品页面点击立即购买跳转至此
			infoMap.put(tGoodsDAO.findById(gids[0]), num);
		} else {
			// num为0，从购物车点击结算跳转至此
			for (int gid : gids) {
				TShoppingcart tShoppingcart = tShoppingcartDAO.findByUidGid(
						uid, gid);
				infoMap.put(tShoppingcart.getTGoods(),
						tShoppingcart.getNumber());
			}
		}
		return infoMap;

	}

	@Override
	/**
	 * 接收买家收货信息创建订单，保存到数据库，并返回aid
	 */
	public String createOrder(int[] gids, Integer uid, String address,
			String receiver, String phone) {
		// 生成aid（3位随机数+14位日期时间+3位随机数）
		String aid = String
				.format("%03d", new Random(new Date().getTime())
						.nextInt((int) Math.pow(10, 3)))
				+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
				+ String.format("%03d", new Random(new Date().getTime())
						.nextInt((int) Math.pow(10, 3)));

		// 获取登录用户对象TUser
		TUser user = tUserDAO.findById(uid);

		// total用于记录订单总价，暂为0
		double total = 0;
		// 实例化TAlreadybuyUser对象，并存入各属性
		TAlreadybuyUser alreadybuyUser = new TAlreadybuyUser();
		alreadybuyUser.setAid(aid);
		alreadybuyUser.setTUser(tUserDAO.findById(uid));
		alreadybuyUser.setTotalprice(total);
		alreadybuyUser.setReceiver(receiver);
		alreadybuyUser.setAddress(address);
		alreadybuyUser.setPhone(phone);
		alreadybuyUser.setCreatetime(new Timestamp(new Date().getTime()));

		// 保存t_alreadybuy_user表
		tAlreadybuyUserDAO.save(alreadybuyUser);

		List<TAlreadybuyGoods> buyGoods = new ArrayList<TAlreadybuyGoods>();
		// 迭代gids数组
		for (int i = 0; i < gids.length; i++) {
			// 根据gid获取goods信息
			TGoods goods = tGoodsDAO.findById(gids[i]);
			// 记录购买时的单价
			Double price = goods.getPrice();
			// 根据uid和 gid获得当前用户的购物车
			TShoppingcart shoppingcart = tShoppingcartDAO.findByUidGid(uid,
					gids[i]);
			// 记录购买数量
			int number = shoppingcart.getNumber();
			// 更新商品剩余库存量
			goods.setNumber(goods.getNumber() - number);
			// 将商品的剩余库存量更新到数据库中
			tGoodsDAO.attachDirty(goods);

			// 计算订单总价
			total += (price * number);

			// 实例化alreadybuyGoods并存入各属性
			TAlreadybuyGoods alreadybuyGoods = new TAlreadybuyGoods();
			alreadybuyGoods.setId(new TAlreadybuyGoodsId(aid, gids[i]));
			alreadybuyGoods.setNumber(number);
			alreadybuyGoods.setPrice(price);
			// 保存t_alreadybuy_goods表
			tAlreadybuyGoodsDAO.save(alreadybuyGoods);
			buyGoods.add(alreadybuyGoods);

			// 在数据库中删除对应的购物车
			tShoppingcartDAO.delete(shoppingcart);
		}

		// 更新表订单总价
		alreadybuyUser.setTotalprice(total);
		tAlreadybuyUserDAO.attachDirty(alreadybuyUser);

		return aid;
	}

	@Override
	/**
	 * 根据aid获取订单详情
	 */
	public OrderDetail getOrderDetail(String aid) {
		TAlreadybuyUser alreadybuyUser = tAlreadybuyUserDAO.findById(aid);
		List<TAlreadybuyGoods> alreadybuyGoodsList = tAlreadybuyGoodsDAO
				.findByAid(aid);

		OrderDetail detail = null;

		if (alreadybuyGoodsList != null && alreadybuyUser != null) {
			List<TGoods> goodsList = new ArrayList<TGoods>();
			List<Integer> numbers = new ArrayList<Integer>();
			List<Double> prices = new ArrayList<Double>();
			List<String> comments = new ArrayList<String>();

			for (TAlreadybuyGoods alreadybuyGoods : alreadybuyGoodsList) {
				goodsList.add(tGoodsDAO.findById(alreadybuyGoods.getId()
						.getGid()));
				numbers.add(alreadybuyGoods.getNumber());
				prices.add(alreadybuyGoods.getPrice());
				comments.add(alreadybuyGoods.getComment());
			}

			detail = new OrderDetail();
			detail.setAid(aid);
			detail.setTGoods(goodsList);
			detail.setNumber(numbers);
			detail.setPrice(prices);
			detail.setComment(comments);
			detail.setCreatetime(alreadybuyUser.getCreatetime());
			detail.setPaytime(alreadybuyUser.getPaytime());
			detail.setSendtime(alreadybuyUser.getSendtime());
			detail.setCarriage(alreadybuyUser.getCarriage());
			detail.setReceivetime(alreadybuyUser.getReceivetime());
			detail.setIsCancel(alreadybuyUser.getIsCancel());
			detail.setAddress(alreadybuyUser.getAddress());
			detail.setReceiver(alreadybuyUser.getReceiver());
			detail.setPhone(alreadybuyUser.getPhone());
			detail.setTotalprice(alreadybuyUser.getTotalprice());
		}

		return detail;
	}

	public List<String> getOrderAids(int uid) {
		List<String> aids = new ArrayList<String>();
		List<TAlreadybuyUser> list = tAlreadybuyUserDAO.findByUid(uid);
		for (TAlreadybuyUser tAlreadybuyUser : list) {
			aids.add(tAlreadybuyUser.getAid());
		}

		return aids;
	}

	@Override
	public OrderDetail cancelOrder(String aid) {
		TAlreadybuyUser alreadybuyUser = tAlreadybuyUserDAO.findById(aid);
		if (alreadybuyUser != null) {
			alreadybuyUser.setIsCancel(true);
			tAlreadybuyUserDAO.attachDirty(alreadybuyUser);
		}
		return getOrderDetail(aid);
	}

	@Override
	public OrderDetail received(String aid) {
		TAlreadybuyUser alreadybuyUser = tAlreadybuyUserDAO.findById(aid);
		if (alreadybuyUser != null) {
			alreadybuyUser.setReceivetime(new Timestamp(new Date().getTime()));
			tAlreadybuyUserDAO.attachDirty(alreadybuyUser);
		}
		return getOrderDetail(aid);
	}

	@Override
	public OrderDetail payOrder(String aid) {
		TAlreadybuyUser alreadybuyUser = tAlreadybuyUserDAO.findById(aid);
		if (alreadybuyUser != null) {
			alreadybuyUser.setPaytime(new Timestamp(new Date().getTime()));
			tAlreadybuyUserDAO.attachDirty(alreadybuyUser);
		}
		return getOrderDetail(aid);
	}

	@Override
	public void putComment(String aid, int gid, String comment) {
		TAlreadybuyGoods alreadybuyGoods = tAlreadybuyGoodsDAO
				.findById(new TAlreadybuyGoodsId(aid, gid));
		alreadybuyGoods.setComment(comment);
		tAlreadybuyGoodsDAO.attachDirty(alreadybuyGoods);
	}

	@Override
	public Timestamp sendGoods(String aid, String carriage) {
		TAlreadybuyUser alreadybuyUser = tAlreadybuyUserDAO.findById(aid);
		Timestamp sendTime = new Timestamp(new Date().getTime());
		alreadybuyUser.setSendtime(sendTime);
		alreadybuyUser.setCarriage(carriage);
		tAlreadybuyUserDAO.attachDirty(alreadybuyUser);
		return sendTime;
	}
}
