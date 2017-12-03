
package team.jmu.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable
{

	// Fields

	private Integer uid;
	private String uname;
	private String email;
	private String password;
	private Timestamp lastlogin;
	private Set TShoppingcarts = new HashSet( 0 );
	private Set TAlreadybuyUsers = new HashSet( 0 );

	// Constructors

	/** default constructor */
	public TUser()
	{
	}

	/** minimal constructor */
	public TUser( Integer uid, String uname, String email, String password )
	{
		this.uid = uid;
		this.uname = uname;
		this.email = email;
		this.password = password;
	}

	/** full constructor */
	public TUser( Integer uid, String uname, String email, String password,
			Timestamp lastlogin, Set TShoppingcarts, Set TAlreadybuyUsers )
	{
		this.uid = uid;
		this.uname = uname;
		this.email = email;
		this.password = password;
		this.lastlogin = lastlogin;
		this.TShoppingcarts = TShoppingcarts;
		this.TAlreadybuyUsers = TAlreadybuyUsers;
	}

	// Property accessors

	public Integer getUid()
	{
		return this.uid;
	}

	public void setUid( Integer uid )
	{
		this.uid = uid;
	}

	public String getUname()
	{
		return this.uname;
	}

	public void setUname( String uname )
	{
		this.uname = uname;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail( String email )
	{
		this.email = email;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword( String password )
	{
		this.password = password;
	}

	public Timestamp getLastlogin()
	{
		return this.lastlogin;
	}

	public void setLastlogin( Timestamp lastlogin )
	{
		this.lastlogin = lastlogin;
	}

	public Set getTShoppingcarts()
	{
		return this.TShoppingcarts;
	}

	public void setTShoppingcarts( Set TShoppingcarts )
	{
		this.TShoppingcarts = TShoppingcarts;
	}

	public Set getTAlreadybuyUsers()
	{
		return this.TAlreadybuyUsers;
	}

	public void setTAlreadybuyUsers( Set TAlreadybuyUsers )
	{
		this.TAlreadybuyUsers = TAlreadybuyUsers;
	}

}