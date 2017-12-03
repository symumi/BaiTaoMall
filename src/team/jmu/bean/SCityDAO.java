
package team.jmu.bean;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for SCity entities.
 * Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions.
 * Each of these methods provides additional information for how to configure it for the desired
 * type of transaction control.
 * 
 * @see team.jmu.bean.SCity
 * @author MyEclipse Persistence Tools
 */
public class SCityDAO extends HibernateDaoSupport
{
	private static final Logger log = LoggerFactory.getLogger( SCityDAO.class );
	// property constants
	public static final String CITY_NAME = "cityName";
	public static final String ZIP_CODE = "zipCode";
	public static final String PROVINCE_ID = "provinceId";

	protected void initDao()
	{
		// do nothing
	}

	public void save( SCity transientInstance )
	{
		log.debug( "saving SCity instance" );
		try
		{
			getHibernateTemplate().save( transientInstance );
			log.debug( "save successful" );
		} catch( RuntimeException re )
		{
			log.error( "save failed", re );
			throw re;
		}
	}

	public void delete( SCity persistentInstance )
	{
		log.debug( "deleting SCity instance" );
		try
		{
			getHibernateTemplate().delete( persistentInstance );
			log.debug( "delete successful" );
		} catch( RuntimeException re )
		{
			log.error( "delete failed", re );
			throw re;
		}
	}

	public SCity findById( java.lang.Long id )
	{
		log.debug( "getting SCity instance with id: " + id );
		try
		{
			SCity instance = (SCity)getHibernateTemplate().get(
					"team.jmu.bean.SCity", id );
			return instance;
		} catch( RuntimeException re )
		{
			log.error( "get failed", re );
			throw re;
		}
	}

	public List findByExample( SCity instance )
	{
		log.debug( "finding SCity instance by example" );
		try
		{
			List results = getHibernateTemplate().findByExample( instance );
			log.debug( "find by example successful, result size: "
					+ results.size() );
			return results;
		} catch( RuntimeException re )
		{
			log.error( "find by example failed", re );
			throw re;
		}
	}

	public List findByProperty( String propertyName, Object value )
	{
		log.debug( "finding SCity instance with property: " + propertyName
				+ ", value: " + value );
		try
		{
			String queryString = "from SCity as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find( queryString, value );
		} catch( RuntimeException re )
		{
			log.error( "find by property name failed", re );
			throw re;
		}
	}

	public List findByCityName( Object cityName )
	{
		return findByProperty( CITY_NAME, cityName );
	}

	public List findByZipCode( Object zipCode )
	{
		return findByProperty( ZIP_CODE, zipCode );
	}

	public List findByProvinceId( Object provinceId )
	{
		return findByProperty( PROVINCE_ID, provinceId );
	}

	public List findAll()
	{
		log.debug( "finding all SCity instances" );
		try
		{
			String queryString = "from SCity";
			return getHibernateTemplate().find( queryString );
		} catch( RuntimeException re )
		{
			log.error( "find all failed", re );
			throw re;
		}
	}

	public SCity merge( SCity detachedInstance )
	{
		log.debug( "merging SCity instance" );
		try
		{
			SCity result = (SCity)getHibernateTemplate().merge(
					detachedInstance );
			log.debug( "merge successful" );
			return result;
		} catch( RuntimeException re )
		{
			log.error( "merge failed", re );
			throw re;
		}
	}

	public void attachDirty( SCity instance )
	{
		log.debug( "attaching dirty SCity instance" );
		try
		{
			getHibernateTemplate().saveOrUpdate( instance );
			log.debug( "attach successful" );
		} catch( RuntimeException re )
		{
			log.error( "attach failed", re );
			throw re;
		}
	}

	public void attachClean( SCity instance )
	{
		log.debug( "attaching clean SCity instance" );
		try
		{
			getHibernateTemplate().lock( instance, LockMode.NONE );
			log.debug( "attach successful" );
		} catch( RuntimeException re )
		{
			log.error( "attach failed", re );
			throw re;
		}
	}

	public static SCityDAO getFromApplicationContext( ApplicationContext ctx )
	{
		return (SCityDAO)ctx.getBean( "SCityDAO" );
	}
}