
package team.jmu.dao;

import team.jmu.bean.TUser;

public abstract class AbsUser
{
	// 鐧诲綍
	public abstract TUser login( TUser user );
	
	public abstract void setLastLogin(TUser u);

	// 娉ㄥ唽
	public abstract boolean sign( TUser user );

	// 娉ㄩ攢
	public abstract void logout();
	
	//修改
	public abstract void modify(TUser user);
}
