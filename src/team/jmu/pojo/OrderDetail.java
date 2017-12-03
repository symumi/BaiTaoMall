
package team.jmu.pojo;

import java.sql.Timestamp;
import java.util.List;

import team.jmu.bean.TGoods;

public class OrderDetail
{
	private String aid;
	private List<TGoods> TGoods;
	private List<Integer> number;
	private List<Double> price;
	private List<String> comment;
	private Timestamp createtime;
	private Timestamp paytime;
	private Timestamp sendtime;
	private Timestamp receivetime;
	private Boolean isCancel;
	private String carriage;
	private Double totalprice;
	private String receiver;
	private String address;
	private String phone;

	public OrderDetail()
	{
		super();
	}

	public OrderDetail( String aid, List<team.jmu.bean.TGoods> tGoods,
			List<Integer> number, Timestamp createtime, Boolean isCancel,
			List<Double> price, Double totalprice, String receiver,
			String address, String phone )
	{
		super();
		this.aid = aid;
		TGoods = tGoods;
		this.number = number;
		this.createtime = createtime;
		this.isCancel = isCancel;
		this.price = price;
		this.totalprice = totalprice;
		this.receiver = receiver;
		this.address = address;
		this.phone = phone;
	}

	public OrderDetail( String aid, List<team.jmu.bean.TGoods> tGoods,
			List<Integer> number, Timestamp createtime, Timestamp paytime,
			Timestamp sendtime, Timestamp receivetime, Boolean isCancel,
			String carriage, List<String> comment, List<Double> price,
			Double totalprice, String receiver, String address, String phone )
	{
		super();
		this.aid = aid;
		TGoods = tGoods;
		this.number = number;
		this.createtime = createtime;
		this.paytime = paytime;
		this.sendtime = sendtime;
		this.receivetime = receivetime;
		this.isCancel = isCancel;
		this.carriage = carriage;
		this.comment = comment;
		this.price = price;
		this.totalprice = totalprice;
		this.receiver = receiver;
		this.address = address;
		this.phone = phone;
	}

	public String getAid()
	{
		return aid;
	}

	public void setAid( String aid )
	{
		this.aid = aid;
	}

	public List<TGoods> getTGoods()
	{
		return TGoods;
	}

	public void setTGoods( List<TGoods> tGoods )
	{
		TGoods = tGoods;
	}

	public List<Integer> getNumber()
	{
		return number;
	}

	public void setNumber( List<Integer> number )
	{
		this.number = number;
	}

	public Timestamp getCreatetime()
	{
		return createtime;
	}

	public void setCreatetime( Timestamp createtime )
	{
		this.createtime = createtime;
	}

	public Timestamp getPaytime()
	{
		return paytime;
	}

	public void setPaytime( Timestamp paytime )
	{
		this.paytime = paytime;
	}

	public Timestamp getSendtime()
	{
		return sendtime;
	}

	public void setSendtime( Timestamp sendtime )
	{
		this.sendtime = sendtime;
	}

	public Timestamp getReceivetime()
	{
		return receivetime;
	}

	public void setReceivetime( Timestamp receivetime )
	{
		this.receivetime = receivetime;
	}

	public Boolean getIsCancel()
	{
		return isCancel;
	}

	public void setIsCancel( Boolean isCancel )
	{
		this.isCancel = isCancel;
	}

	public String getCarriage()
	{
		return carriage;
	}

	public void setCarriage( String carriage )
	{
		this.carriage = carriage;
	}

	public List<Double> getPrice()
	{
		return price;
	}

	public void setPrice( List<Double> price )
	{
		this.price = price;
	}

	public Double getTotalprice()
	{
		return totalprice;
	}

	public void setTotalprice( Double totalprice )
	{
		this.totalprice = totalprice;
	}

	public String getReceiver()
	{
		return receiver;
	}

	public void setReceiver( String receiver )
	{
		this.receiver = receiver;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress( String address )
	{
		this.address = address;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone( String phone )
	{
		this.phone = phone;
	}

	public List<String> getComment()
	{
		return comment;
	}

	public void setComment( List<String> comment )
	{
		this.comment = comment;
	}

	@Override
	public String toString()
	{
		return "OrderDetail [aid=" + aid + ", TGoods=" + TGoods + ", number="
				+ number + ", price=" + price + ", comment=" + comment
				+ ", createtime=" + createtime + ", paytime=" + paytime
				+ ", sendtime=" + sendtime + ", receivetime=" + receivetime
				+ ", isCancel=" + isCancel + ", carriage=" + carriage
				+ ", totalprice=" + totalprice + ", receiver=" + receiver
				+ ", address=" + address + ", phone=" + phone + "]";
	}

}
