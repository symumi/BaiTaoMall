
package team.jmu.bean;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for SDistrict entities.
 * Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions.
 * Each of these methods provides additional information for how to configure it for the desired
 * type of transaction control.
 * 
 * @see team.jmu.bean.SDistrict
 * @author MyEclipse Persistence Tools
 */
public class SDistrictDAO extends HibernateDaoSupport
{
	private static final Logger log = LoggerFactory
			.getLogger( SDistrictDAO.class );
	// property constants
	public static final String DISTRICT_NAME = "districtName";
	public static final String CITY_ID = "cityId";

	protected void initDao()
	{
		// do nothing
	}

	public void save( SDistrict transientInstance )
	{
		log.debug( "saving SDistrict instance" );
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

	public void delete( SDistrict persistentInstance )
	{
		log.debug( "deleting SDistrict instance" );
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

	public SDistrict findById( java.lang.Long id )
	{
		log.debug( "getting SDistrict instance with id: " + id );
		try
		{
			SDistrict instance = (SDistrict)getHibernateTemplate().get(
					"team.jmu.bean.SDistrict", id );
			return instance;
		} catch( RuntimeException re )
		{
			log.error( "get failed", re );
			throw re;
		}
	}

	public List findByExample( SDistrict instance )
	{
		log.debug( "finding SDistrict instance by example" );
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
		log.debug( "finding SDistrict instance with property: " + propertyName
				+ ", value: " + value );
		try
		{
			String queryString = "from SDistrict as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find( queryString, value );
		} catch( RuntimeException re )
		{
			log.error( "find by property name failed", re );
			throw re;
		}
	}

	public List findByDistrictName( Object districtName )
	{
		return findByProperty( DISTRICT_NAME, districtName );
	}

	public List findByCityId( Object cityId )
	{
		return findByProperty( CITY_ID, cityId );
	}

	public List findAll()
	{
		log.debug( "finding all SDistrict instances" );
		try
		{
			String queryString = "from SDistrict";
			return getHibernateTemplate().find( queryString );
		} catch( RuntimeException re )
		{
			log.error( "find all failed", re );
			throw re;
		}
	}

	public SDistrict merge( SDistrict detachedInstance )
	{
		log.debug( "merging SDistrict instance" );
		try
		{
			SDistrict result = (SDistrict)getHibernateTemplate().merge(
					detachedInstance );
			log.debug( "merge successful" );
			return result;
		} catch( RuntimeException re )
		{
			log.error( "merge failed", re );
			throw re;
		}
	}

	public void attachDirty( SDistrict instance )
	{
		log.debug( "attaching dirty SDistrict instance" );
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

	public void attachClean( SDistrict instance )
	{
		log.debug( "attaching clean SDistrict instance" );
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

	public static SDistrictDAO getFromApplicationContext( ApplicationContext ctx )
	{
		return (SDistrictDAO)ctx.getBean( "SDistrictDAO" );
	}
}