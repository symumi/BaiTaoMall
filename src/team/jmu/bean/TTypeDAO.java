
package team.jmu.bean;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for TType entities.
 * Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions.
 * Each of these methods provides additional information for how to configure it for the desired
 * type of transaction control.
 * 
 * @see team.jmu.bean.TType
 * @author MyEclipse Persistence Tools
 */
public class TTypeDAO extends HibernateDaoSupport
{
	private static final Logger log = LoggerFactory.getLogger( TTypeDAO.class );
	// property constants
	public static final String TNAME = "tname";

	protected void initDao()
	{
		// do nothing
	}

	public void save( TType transientInstance )
	{
		log.debug( "saving TType instance" );
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

	public void delete( TType persistentInstance )
	{
		log.debug( "deleting TType instance" );
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

	public TType findById( java.lang.Integer id )
	{
		log.debug( "getting TType instance with id: " + id );
		try
		{
			TType instance = (TType)getHibernateTemplate().get(
					"team.jmu.bean.TType", id );
			return instance;
		} catch( RuntimeException re )
		{
			log.error( "get failed", re );
			throw re;
		}
	}

	public List findByExample( TType instance )
	{
		log.debug( "finding TType instance by example" );
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
		log.debug( "finding TType instance with property: " + propertyName
				+ ", value: " + value );
		try
		{
			String queryString = "from TType as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find( queryString, value );
		} catch( RuntimeException re )
		{
			log.error( "find by property name failed", re );
			throw re;
		}
	}

	public List findByTname( Object tname )
	{
		return findByProperty( TNAME, tname );
	}

	public List findAll()
	{
		log.debug( "finding all TType instances" );
		try
		{
			String queryString = "from TType";
			return getHibernateTemplate().find( queryString );
		} catch( RuntimeException re )
		{
			log.error( "find all failed", re );
			throw re;
		}
	}

	public TType merge( TType detachedInstance )
	{
		log.debug( "merging TType instance" );
		try
		{
			TType result = (TType)getHibernateTemplate().merge(
					detachedInstance );
			log.debug( "merge successful" );
			return result;
		} catch( RuntimeException re )
		{
			log.error( "merge failed", re );
			throw re;
		}
	}

	public void attachDirty( TType instance )
	{
		log.debug( "attaching dirty TType instance" );
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

	public void attachClean( TType instance )
	{
		log.debug( "attaching clean TType instance" );
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

	public static TTypeDAO getFromApplicationContext( ApplicationContext ctx )
	{
		return (TTypeDAO)ctx.getBean( "TTypeDAO" );
	}
}