
package team.jmu.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * TGoods entity. @author MyEclipse Persistence Tools
 */

public class TGoods implements java.io.Serializable
{

	// Fields

	private Integer gid;
	private TType TType;
	private String gname;
	private Long number;
	private String gphoto;
	private Double price;
	private String note;
	private Integer sid;
	private Boolean isExist;
	private Set TAlreadybuyGoodses = new HashSet( 0 );
	private Set TShoppingcarts = new HashSet( 0 );

	// Constructors

	/** default constructor */
	public TGoods()
	{
	}

	/** minimal constructor */
	public TGoods( TType TType, String gname, Long number, String gphoto,
			Double price, String note, Boolean isExist )
	{
		this.TType = TType;
		this.gname = gname;
		this.number = number;
		this.gphoto = gphoto;
		this.price = price;
		this.note = note;
		this.isExist = isExist;
	}

	/** full constructor */
	public TGoods( TType TType, String gname, Long number, String gphoto,
			Double price, String note, Integer sid, Boolean isExist,
			Set TAlreadybuyGoodses, Set TShoppingcarts )
	{
		this.TType = TType;
		this.gname = gname;
		this.number = number;
		this.gphoto = gphoto;
		this.price = price;
		this.note = note;
		this.sid = sid;
		this.isExist = isExist;
		this.TAlreadybuyGoodses = TAlreadybuyGoodses;
		this.TShoppingcarts = TShoppingcarts;
	}

	// Property accessors

	public Integer getGid()
	{
		return this.gid;
	}

	public void setGid( Integer gid )
	{
		this.gid = gid;
	}

	public TType getTType()
	{
		return this.TType;
	}

	public void setTType( TType TType )
	{
		this.TType = TType;
	}

	public String getGname()
	{
		return this.gname;
	}

	public void setGname( String gname )
	{
		this.gname = gname;
	}

	public Long getNumber()
	{
		return this.number;
	}

	public void setNumber( Long number )
	{
		this.number = number;
	}

	public String getGphoto()
	{
		return this.gphoto;
	}

	public void setGphoto( String gphoto )
	{
		this.gphoto = gphoto;
	}

	public Double getPrice()
	{
		return this.price;
	}

	public void setPrice( Double price )
	{
		this.price = price;
	}

	public String getNote()
	{
		return this.note;
	}

	public void setNote( String note )
	{
		this.note = note;
	}

	public Integer getSid()
	{
		return this.sid;
	}

	public void setSid( Integer sid )
	{
		this.sid = sid;
	}

	public Boolean getIsExist()
	{
		return this.isExist;
	}

	public void setIsExist( Boolean isExist )
	{
		this.isExist = isExist;
	}

	public Set getTAlreadybuyGoodses()
	{
		return this.TAlreadybuyGoodses;
	}

	public void setTAlreadybuyGoodses( Set TAlreadybuyGoodses )
	{
		this.TAlreadybuyGoodses = TAlreadybuyGoodses;
	}

	public Set getTShoppingcarts()
	{
		return this.TShoppingcarts;
	}

	public void setTShoppingcarts( Set TShoppingcarts )
	{
		this.TShoppingcarts = TShoppingcarts;
	}

}