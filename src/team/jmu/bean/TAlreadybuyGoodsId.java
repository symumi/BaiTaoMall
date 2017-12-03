
package team.jmu.bean;

/**
 * TAlreadybuyGoodsId entity. @author MyEclipse Persistence Tools
 */

public class TAlreadybuyGoodsId implements java.io.Serializable
{

	// Fields

	private String aid;
	private Integer gid;

	// Constructors

	/** default constructor */
	public TAlreadybuyGoodsId()
	{
	}

	/** full constructor */
	public TAlreadybuyGoodsId( String aid, Integer gid )
	{
		this.aid = aid;
		this.gid = gid;
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

	public Integer getGid()
	{
		return this.gid;
	}

	public void setGid( Integer gid )
	{
		this.gid = gid;
	}

	public boolean equals( Object other )
	{
		if( (this == other) )
			return true;
		if( (other == null) )
			return false;
		if( !(other instanceof TAlreadybuyGoodsId) )
			return false;
		TAlreadybuyGoodsId castOther = (TAlreadybuyGoodsId)other;

		return ((this.getAid() == castOther.getAid()) || (this.getAid() != null
				&& castOther.getAid() != null && this.getAid().equals(
				castOther.getAid() )))
				&& ((this.getGid() == castOther.getGid()) || (this.getGid() != null
						&& castOther.getGid() != null && this.getGid().equals(
						castOther.getGid() )));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result
				+ (getAid() == null ? 0 : this.getAid().hashCode());
		result = 37 * result
				+ (getGid() == null ? 0 : this.getGid().hashCode());
		return result;
	}

}