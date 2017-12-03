
package team.jmu.bean;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for SProvince entities.
 * Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions.
 * Each of these methods provides additional information for how to configure it for the desired
 * type of transaction control.
 * 
 * @see team.jmu.bean.SProvince
 * @author MyEclipse Persistence Tools
 */
public class SProvinceDAO extends HibernateDaoSupport
{
	private static final Logger log = LoggerFactory
			.getLogger( SProvinceDAO.class );
	// property constants
	public static final String PROVINCE_NAME = "provinceName";

	protected void initDao()
	{
		// do nothing
	}

	public void save( SProvince transientInstance )
	{
		log.debug( "saving SProvince instance" );
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

	public void delete( SProvince persistentInstance )
	{
		log.debug( "deleting SProvince instance" );
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

	public SProvince findById( java.lang.Long id )
	{
		log.debug( "getting SProvince instance with id: " + id );
		try
		{
			SProvince instance = (SProvince)getHibernateTemplate().get(
					"team.jmu.bean.SProvince", id );
			return instance;
		} catch( RuntimeException re )
		{
			log.error( "get failed", re );
			throw re;
		}
	}

	public List findByExample( SProvince instance )
	{
		log.debug( "finding SProvince instance by example" );
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
		log.debug( "finding SProvince instance with property: " + propertyName
				+ ", value: " + value );
		try
		{
			String queryString = "from SProvince as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find( queryString, value );
		} catch( RuntimeException re )
		{
			log.error( "find by property name failed", re );
			throw re;
		}
	}

	public List findByProvinceName( Object provinceName )
	{
		return findByProperty( PROVINCE_NAME, provinceName );
	}

	public List findAll()
	{
		log.debug( "finding all SProvince instances" );
		try
		{
			String queryString = "from SProvince";
			return getHibernateTemplate().find( queryString );
		} catch( RuntimeException re )
		{
			log.error( "find all failed", re );
			throw re;
		}
	}

	public SProvince merge( SProvince detachedInstance )
	{
		log.debug( "merging SProvince instance" );
		try
		{
			SProvince result = (SProvince)getHibernateTemplate().merge(
					detachedInstance );
			log.debug( "merge successful" );
			return result;
		} catch( RuntimeException re )
		{
			log.error( "merge failed", re );
			throw re;
		}
	}

	public void attachDirty( SProvince instance )
	{
		log.debug( "attaching dirty SProvince instance" );
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

	public void attachClean( SProvince instance )
	{
		log.debug( "attaching clean SProvince instance" );
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

	public static SProvinceDAO getFromApplicationContext( ApplicationContext ctx )
	{
		return (SProvinceDAO)ctx.getBean( "SProvinceDAO" );
	}
}