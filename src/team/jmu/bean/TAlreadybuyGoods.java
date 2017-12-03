
package team.jmu.bean;

/**
 * TAlreadybuyGoods entity. @author MyEclipse Persistence Tools
 */

public class TAlreadybuyGoods implements java.io.Serializable
{

	// Fields

	private TAlreadybuyGoodsId id;
	private TGoods TGoods;
	private TAlreadybuyUser TAlreadybuyUser;
	private Integer number;
	private String comment;
	private Double price;

	// Constructors

	/** default constructor */
	public TAlreadybuyGoods()
	{
	}

	/** minimal constructor */
	public TAlreadybuyGoods( TAlreadybuyGoodsId id, TGoods TGoods,
			TAlreadybuyUser TAlreadybuyUser, Integer number )
	{
		this.id = id;
		this.TGoods = TGoods;
		this.TAlreadybuyUser = TAlreadybuyUser;
		this.number = number;
	}

	/** full constructor */
	public TAlreadybuyGoods( TAlreadybuyGoodsId id, TGoods TGoods,
			TAlreadybuyUser TAlreadybuyUser, Integer number, String comment,
			Double price )
	{
		this.id = id;
		this.TGoods = TGoods;
		this.TAlreadybuyUser = TAlreadybuyUser;
		this.number = number;
		this.comment = comment;
		this.price = price;
	}

	// Property accessors

	public TAlreadybuyGoodsId getId()
	{
		return this.id;
	}

	public void setId( TAlreadybuyGoodsId id )
	{
		this.id = id;
	}

	public TGoods getTGoods()
	{
		return this.TGoods;
	}

	public void setTGoods( TGoods TGoods )
	{
		this.TGoods = TGoods;
	}

	public TAlreadybuyUser getTAlreadybuyUser()
	{
		return this.TAlreadybuyUser;
	}

	public void setTAlreadybuyUser( TAlreadybuyUser TAlreadybuyUser )
	{
		this.TAlreadybuyUser = TAlreadybuyUser;
	}

	public Integer getNumber()
	{
		return this.number;
	}

	public void setNumber( Integer number )
	{
		this.number = number;
	}

	public String getComment()
	{
		return this.comment;
	}

	public void setComment( String comment )
	{
		this.comment = comment;
	}

	public Double getPrice()
	{
		return this.price;
	}

	public void setPrice( Double price )
	{
		this.price = price;
	}

}