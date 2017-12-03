
package team.jmu.bean;

/**
 * SDistrict entity. @author MyEclipse Persistence Tools
 */

public class SDistrict implements java.io.Serializable
{

	// Fields

	private Long districtId;
	private String districtName;
	private Long cityId;

	// Constructors

	/** default constructor */
	public SDistrict()
	{
	}

	/** minimal constructor */
	public SDistrict( Long districtId )
	{
		this.districtId = districtId;
	}

	/** full constructor */
	public SDistrict( Long districtId, String districtName, Long cityId )
	{
		this.districtId = districtId;
		this.districtName = districtName;
		this.cityId = cityId;
	}

	// Property accessors

	public Long getDistrictId()
	{
		return this.districtId;
	}

	public void setDistrictId( Long districtId )
	{
		this.districtId = districtId;
	}

	public String getDistrictName()
	{
		return this.districtName;
	}

	public void setDistrictName( String districtName )
	{
		this.districtName = districtName;
	}

	public Long getCityId()
	{
		return this.cityId;
	}

	public void setCityId( Long cityId )
	{
		this.cityId = cityId;
	}

}