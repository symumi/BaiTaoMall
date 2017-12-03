
package team.jmu.bean;

/**
 * SCity entity. @author MyEclipse Persistence Tools
 */

public class SCity implements java.io.Serializable
{

	// Fields

	private Long cityId;
	private String cityName;
	private String zipCode;
	private Long provinceId;

	// Constructors

	/** default constructor */
	public SCity()
	{
	}

	/** minimal constructor */
	public SCity( Long cityId )
	{
		this.cityId = cityId;
	}

	/** full constructor */
	public SCity( Long cityId, String cityName, String zipCode, Long provinceId )
	{
		this.cityId = cityId;
		this.cityName = cityName;
		this.zipCode = zipCode;
		this.provinceId = provinceId;
	}

	// Property accessors

	public Long getCityId()
	{
		return this.cityId;
	}

	public void setCityId( Long cityId )
	{
		this.cityId = cityId;
	}

	public String getCityName()
	{
		return this.cityName;
	}

	public void setCityName( String cityName )
	{
		this.cityName = cityName;
	}

	public String getZipCode()
	{
		return this.zipCode;
	}

	public void setZipCode( String zipCode )
	{
		this.zipCode = zipCode;
	}

	public Long getProvinceId()
	{
		return this.provinceId;
	}

	public void setProvinceId( Long provinceId )
	{
		this.provinceId = provinceId;
	}

}