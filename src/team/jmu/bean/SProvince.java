
package team.jmu.bean;

/**
 * SProvince entity. @author MyEclipse Persistence Tools
 */

public class SProvince implements java.io.Serializable
{

	// Fields

	private Long provinceId;
	private String provinceName;

	// Constructors

	/** default constructor */
	public SProvince()
	{
	}

	/** minimal constructor */
	public SProvince( Long provinceId )
	{
		this.provinceId = provinceId;
	}

	/** full constructor */
	public SProvince( Long provinceId, String provinceName )
	{
		this.provinceId = provinceId;
		this.provinceName = provinceName;
	}

	// Property accessors

	public Long getProvinceId()
	{
		return this.provinceId;
	}

	public void setProvinceId( Long provinceId )
	{
		this.provinceId = provinceId;
	}

	public String getProvinceName()
	{
		return this.provinceName;
	}

	public void setProvinceName( String provinceName )
	{
		this.provinceName = provinceName;
	}

}