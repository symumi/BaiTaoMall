package team.jmu.daoImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import team.jmu.bean.TUser;
import team.jmu.bean.TUserDAO;
import team.jmu.dao.AbsUser;

public class AbsUersImpl extends AbsUser {
	private static ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	private static TUserDAO dao = (TUserDAO) context.getBean("TUserDAO");

	@Override
	public TUser login(TUser u) {
		TUser user = new TUser();
		List<TUser> list = dao.findByUname(u.getUname());
		if (!list.isEmpty()) {
			user = list.get(0);
			return user;
		} else
			return null;
	}

	public void setLastLogin(TUser u) {
		dao.attachDirty(u);
	}

	@Override
	public boolean sign(TUser u) {
		if (dao.findByUname(u.getUname()).isEmpty()) {
			dao.save(u);
			return true;
		} else
			return false;
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(TUser u) {
		dao.merge(u);
	}

	public boolean findUserByName(String username) {
		TUser user = new TUser();
		List<TUser> list = dao.findByUname(username);
		System.out.println(username);
		if (list.isEmpty())
			return true;
		else
			return false;
	}

	public List<TUser> getAllUsers() {
		return dao.findAll();
	}
}
