
package team.jmu.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * TType entity. @author MyEclipse Persistence Tools
 */

public class TType implements java.io.Serializable
{

	// Fields

	private Integer tid;
	private String tname;
	private Set TGoodses = new HashSet( 0 );

	// Constructors

	/** default constructor */
	public TType()
	{
	}

	/** minimal constructor */
	public TType( Integer tid, String tname )
	{
		this.tid = tid;
		this.tname = tname;
	}

	/** full constructor */
	public TType( Integer tid, String tname, Set TGoodses )
	{
		this.tid = tid;
		this.tname = tname;
		this.TGoodses = TGoodses;
	}

	// Property accessors

	public Integer getTid()
	{
		return this.tid;
	}

	public void setTid( Integer tid )
	{
		this.tid = tid;
	}

	public String getTname()
	{
		return this.tname;
	}

	public void setTname( String tname )
	{
		this.tname = tname;
	}

	public Set getTGoodses()
	{
		return this.TGoodses;
	}

	public void setTGoodses( Set TGoodses )
	{
		this.TGoodses = TGoodses;
	}

}