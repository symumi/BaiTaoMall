
package team.jmu.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * TAlreadybuyUser entity. @author MyEclipse Persistence Tools
 */

public class TAlreadybuyUser implements java.io.Serializable
{

	// Fields

	private String aid;
	private TUser TUser;
	private Double totalprice;
	private String receiver;
	private String address;
	private String phone;
	private String carriage;
	private Timestamp createtime;
	private Timestamp paytime;
	private Timestamp sendtime;
	private Timestamp receivetime;
	private Boolean isCancel = false;
	private Set TAlreadybuyGoodses = new HashSet( 0 );

	// Constructors

	/** default constructor */
	public TAlreadybuyUser()
	{
	}

	/** minimal constructor */
	public TAlreadybuyUser( String aid, TUser TUser, Double totalprice,
			String receiver, String address, String phone,
			Timestamp createtime, Boolean isCancel )
	{
		this.aid = aid;
		this.TUser = TUser;
		this.totalprice = totalprice;
		this.receiver = receiver;
		this.address = address;
		this.phone = phone;
		this.createtime = createtime;
		this.isCancel = isCancel;
	}

	/** full constructor */
	public TAlreadybuyUser( String aid, TUser TUser, Double totalprice,
			String receiver, String address, String phone, String carriage,
			Timestamp createtime, Timestamp paytime, Timestamp sendtime,
			Timestamp receivetime, Boolean isCancel, Set TAlreadybuyGoodses )
	{
		this.aid = aid;
		this.TUser = TUser;
		this.totalprice = totalprice;
		this.receiver = receiver;
		this.address = address;
		this.phone = phone;
		this.carriage = carriage;
		this.createtime = createtime;
		this.paytime = paytime;
		this.sendtime = sendtime;
		this.receivetime = receivetime;
		this.isCancel = isCancel;
		this.TAlreadybuyGoodses = TAlreadybuyGoodses;
	}

	// Property accessors

	public String getAid()
	{
		return this.aid;
	}

	public void setAid( String aid )
	{
		this.aid = aid;
	}

	public TUser getTUser()
	{
		return this.TUser;
	}

	public void setTUser( TUser TUser )
	{
		this.TUser = TUser;
	}

	public Double getTotalprice()
	{
		return this.totalprice;
	}

	public void setTotalprice( Double totalprice )
	{
		this.totalprice = totalprice;
	}

	public String getReceiver()
	{
		return this.receiver;
	}

	public void setReceiver( String receiver )
	{
		this.receiver = receiver;
	}

	public String getAddress()
	{
		return this.address;
	}

	public void setAddress( String address )
	{
		this.address = address;
	}

	public String getPhone()
	{
		return this.phone;
	}

	public void setPhone( String phone )
	{
		this.phone = phone;
	}

	public String getCarriage()
	{
		return this.carriage;
	}

	public void setCarriage( String carriage )
	{
		this.carriage = carriage;
	}

	public Timestamp getCreatetime()
	{
		return this.createtime;
	}

	public void setCreatetime( Timestamp createtime )
	{
		this.createtime = createtime;
	}

	public Timestamp getPaytime()
	{
		return this.paytime;
	}

	public void setPaytime( Timestamp paytime )
	{
		this.paytime = paytime;
	}

	public Timestamp getSendtime()
	{
		return this.sendtime;
	}

	public void setSendtime( Timestamp sendtime )
	{
		this.sendtime = sendtime;
	}

	public Timestamp getReceivetime()
	{
		return this.receivetime;
	}

	public void setReceivetime( Timestamp receivetime )
	{
		this.receivetime = receivetime;
	}

	public Boolean getIsCancel()
	{
		return this.isCancel;
	}

	public void setIsCancel( Boolean isCancel )
	{
		this.isCancel = isCancel;
	}

	public Set getTAlreadybuyGoodses()
	{
		return this.TAlreadybuyGoodses;
	}

	public void setTAlreadybuyGoodses( Set TAlreadybuyGoodses )
	{
		this.TAlreadybuyGoodses = TAlreadybuyGoodses;
	}

}