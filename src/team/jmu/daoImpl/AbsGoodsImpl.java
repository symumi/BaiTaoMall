package team.jmu.daoImpl;

import java.util.HashSet;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import team.jmu.bean.TAlreadybuyGoods;
import team.jmu.bean.TAlreadybuyGoodsDAO;
import team.jmu.bean.TGoods;
import team.jmu.bean.TGoodsDAO;
import team.jmu.bean.TType;
import team.jmu.bean.TTypeDAO;
import team.jmu.dao.AbsGoods;

public class AbsGoodsImpl extends AbsGoods {

	private static final ApplicationContext act = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	private static final TGoodsDAO gao = (TGoodsDAO) act.getBean("TGoodsDAO");

	private static final TTypeDAO tao = (TTypeDAO) act.getBean("TTypeDAO");


	private static final TAlreadybuyGoodsDAO agao = (TAlreadybuyGoodsDAO) act
			.getBean("TAlreadybuyGoodsDAO");

	public List<TGoods> findAll() {
		List<TGoods> goods = gao.findByIsExist(true);
		return goods;
	}

	@Override
	public boolean createGoods(TGoods goods, int tid) {
		TType type = tao.findById(tid);
		goods.setTType(type);
		gao.save(goods);
		return true;
	}

	@Override
	public void updateGoods(TGoods goods, int tid) {
		TType type = tao.findById(tid);
		goods.setTType(type);
		gao.merge(goods);
	}

	@Override
	public List<TGoods> findGoodsByName(String gname) {
		List<TGoods> goods = gao.findByName(gname);
		return goods;
	}

	@Override
	public List<TGoods> findGoodsByType(int tid) {
		List<TGoods> goods = gao.findBytid(tid);
		return goods;
	}

	public List<TType> GoodsType() {
		List<TType> types = tao.findAll();
		return types;
	}

	@Override
	public void deleteGoods(int gid) {
		TGoods goods = gao.findById(gid);
		goods.setIsExist(false);
		gao.merge(goods);
	}

	public TGoods getTheGoods(int gid) {
		TGoods goods = gao.findById(gid);
		return goods;
	}

	public HashSet<TGoods> getTenGoods() {
		int length = 4;
		List<TGoods> goodsList = gao.findByIsExist(true);
		HashSet<TGoods> result = new HashSet();
		if (goodsList.size() < length) {
			result.addAll(goodsList);
		} else {
			while (result.size() < length) {
				result.add(goodsList.get((int) (Math.random() * goodsList
						.size())));
			}
		}
		return result;
	}

	@Override
	public TGoods findGoodsById(int gid) {
		TGoods goods = gao.findById(gid);
		return goods;
	}

	public List<TAlreadybuyGoods> findGoodsListByid(int gid) {
		List<TAlreadybuyGoods> ag = agao.findByProperty("id.gid", gid);
		return ag;
	}

}
