
package team.jmu.bean;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for TAlreadybuyUser entities.
 * Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions.
 * Each of these methods provides additional information for how to configure it for the desired
 * type of transaction control.
 * 
 * @see team.jmu.bean.TAlreadybuyUser
 * @author MyEclipse Persistence Tools
 */
public class TAlreadybuyUserDAO extends HibernateDaoSupport
{
	private static final Logger log = LoggerFactory
			.getLogger( TAlreadybuyUserDAO.class );
	// property constants
	public static final String TOTALPRICE = "totalprice";
	public static final String RECEIVER = "receiver";
	public static final String ADDRESS = "address";
	public static final String PHONE = "phone";
	public static final String CARRIAGE = "carriage";
	public static final String IS_CANCEL = "isCancel";

	protected void initDao()
	{
		// do nothing
	}

	public void save( TAlreadybuyUser transientInstance )
	{
		log.debug( "saving TAlreadybuyUser instance" );
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

	public void delete( TAlreadybuyUser persistentInstance )
	{
		log.debug( "deleting TAlreadybuyUser instance" );
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

	public TAlreadybuyUser findById( java.lang.String id )
	{
		log.debug( "getting TAlreadybuyUser instance with id: " + id );
		try
		{
			TAlreadybuyUser instance = (TAlreadybuyUser)getHibernateTemplate()
					.get( "team.jmu.bean.TAlreadybuyUser", id );
			return instance;
		} catch( RuntimeException re )
		{
			log.error( "get failed", re );
			throw re;
		}
	}

	public List findByExample( TAlreadybuyUser instance )
	{
		log.debug( "finding TAlreadybuyUser instance by example" );
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
		log.debug( "finding TAlreadybuyUser instance with property: "
				+ propertyName + ", value: " + value );
		try
		{
			String queryString = "from TAlreadybuyUser as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find( queryString, value );
		} catch( RuntimeException re )
		{
			log.error( "find by property name failed", re );
			throw re;
		}
	}

	public List findByTotalprice( Object totalprice )
	{
		return findByProperty( TOTALPRICE, totalprice );
	}

	public List findByReceiver( Object receiver )
	{
		return findByProperty( RECEIVER, receiver );
	}

	public List findByAddress( Object address )
	{
		return findByProperty( ADDRESS, address );
	}

	public List findByPhone( Object phone )
	{
		return findByProperty( PHONE, phone );
	}

	public List findByCarriage( Object carriage )
	{
		return findByProperty( CARRIAGE, carriage );
	}

	public List findByIsCancel( Object isCancel )
	{
		return findByProperty( IS_CANCEL, isCancel );
	}

	public List findAll()
	{
		log.debug( "finding all TAlreadybuyUser instances" );
		try
		{
			String queryString = "from TAlreadybuyUser";
			return getHibernateTemplate().find( queryString );
		} catch( RuntimeException re )
		{
			log.error( "find all failed", re );
			throw re;
		}
	}

	public TAlreadybuyUser merge( TAlreadybuyUser detachedInstance )
	{
		log.debug( "merging TAlreadybuyUser instance" );
		try
		{
			TAlreadybuyUser result = (TAlreadybuyUser)getHibernateTemplate()
					.merge( detachedInstance );
			log.debug( "merge successful" );
			return result;
		} catch( RuntimeException re )
		{
			log.error( "merge failed", re );
			throw re;
		}
	}

	public void attachDirty( TAlreadybuyUser instance )
	{
		log.debug( "attaching dirty TAlreadybuyUser instance" );
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

	public void attachClean( TAlreadybuyUser instance )
	{
		log.debug( "attaching clean TAlreadybuyUser instance" );
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

	public static TAlreadybuyUserDAO getFromApplicationContext(
			ApplicationContext ctx )
	{
		return (TAlreadybuyUserDAO)ctx.getBean( "TAlreadybuyUserDAO" );
	}

	public List findByUid( int uid )
	{
		List<TAlreadybuyUser> result = new ArrayList<TAlreadybuyUser>();
		List<TAlreadybuyUser> alreadybuyUsers = findAll();
		for( TAlreadybuyUser tAlreadybuyUser : alreadybuyUsers )
		{
			if( tAlreadybuyUser.getTUser().getUid() == uid )
			{
				result.add( tAlreadybuyUser );
			}
		}
		return result;
	}
}