
package team.jmu.bean;

/**
 * TShoppingcart entity. @author MyEclipse Persistence Tools
 */

public class TShoppingcart implements java.io.Serializable
{

	// Fields

	private Integer sid;
	private TGoods TGoods;
	private TUser TUser;
	private Integer number;

	// Constructors

	/** default constructor */
	public TShoppingcart()
	{
	}

	/** full constructor */
	public TShoppingcart( Integer sid, TGoods TGoods, TUser TUser,
			Integer number )
	{
		this.sid = sid;
		this.TGoods = TGoods;
		this.TUser = TUser;
		this.number = number;
	}

	// Property accessors

	public TShoppingcart( TGoods TGoods, TUser TUser, Integer number )
	{
		this.TGoods = TGoods;
		this.TUser = TUser;
		this.number = number;
	}

	public Integer getSid()
	{
		return this.sid;
	}

	public void setSid( Integer sid )
	{
		this.sid = sid;
	}

	public TGoods getTGoods()
	{
		return this.TGoods;
	}

	public void setTGoods( TGoods TGoods )
	{
		this.TGoods = TGoods;
	}

	public TUser getTUser()
	{
		return this.TUser;
	}

	public void setTUser( TUser TUser )
	{
		this.TUser = TUser;
	}

	public Integer getNumber()
	{
		return this.number;
	}

	public void setNumber( Integer number )
	{
		this.number = number;
	}

}