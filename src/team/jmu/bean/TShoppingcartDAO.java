
package team.jmu.bean;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for TShoppingcart entities.
 * Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions.
 * Each of these methods provides additional information for how to configure it for the desired
 * type of transaction control.
 * 
 * @see team.jmu.bean.TShoppingcart
 * @author MyEclipse Persistence Tools
 */
public class TShoppingcartDAO extends HibernateDaoSupport
{
	private static final Logger log = LoggerFactory
			.getLogger( TShoppingcartDAO.class );
	// property constants
	public static final String NUMBER = "number";

	protected void initDao()
	{
		// do nothing
	}

	public void save( TShoppingcart transientInstance )
	{
		log.debug( "saving TShoppingcart instance" );
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

	public void delete( TShoppingcart persistentInstance )
	{
		log.debug( "deleting TShoppingcart instance" );
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

	public TShoppingcart findById( java.lang.Integer id )
	{
		log.debug( "getting TShoppingcart instance with id: " + id );
		try
		{
			TShoppingcart instance = (TShoppingcart)getHibernateTemplate().get(
					"team.jmu.bean.TShoppingcart", id );
			return instance;
		} catch( RuntimeException re )
		{
			log.error( "get failed", re );
			throw re;
		}
	}

	public List findByExample( TShoppingcart instance )
	{
		log.debug( "finding TShoppingcart instance by example" );
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
		log.debug( "finding TShoppingcart instance with property: "
				+ propertyName + ", value: " + value );
		try
		{
			String queryString = "from TShoppingcart as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find( queryString, value );
		} catch( RuntimeException re )
		{
			log.error( "find by property name failed", re );
			throw re;
		}
	}

	public List findByNumber( Object number )
	{
		return findByProperty( NUMBER, number );
	}

	// 返回该uid下的数据
	public List findByUid( int uid )
	{
		List<TShoppingcart> result = findAll();
		for( TShoppingcart shoppingcart : result )
		{
			if( shoppingcart.getTUser().getUid() != uid )
			{
				result.remove( shoppingcart );
			}
		}
		return result;
	}

	// 返回该uid和gid下的数据
	public TShoppingcart findByUidGid( int uid, int gid )
	{
		List<TShoppingcart> allList = findAll();
		TShoppingcart result = null;
		for( TShoppingcart shoppingcart : allList )
		{
			if( shoppingcart.getTUser().getUid() == uid
					&& shoppingcart.getTGoods().getGid() == gid )
			{
				result = shoppingcart;
				break;
			}
		}
		return result;
	}

	public List findAll()
	{
		log.debug( "finding all TShoppingcart instances" );
		try
		{
			String queryString = "from TShoppingcart";
			return getHibernateTemplate().find( queryString );
		} catch( RuntimeException re )
		{
			log.error( "find all failed", re );
			throw re;
		}
	}

	public TShoppingcart merge( TShoppingcart detachedInstance )
	{
		log.debug( "merging TShoppingcart instance" );
		try
		{
			TShoppingcart result = (TShoppingcart)getHibernateTemplate().merge(
					detachedInstance );
			log.debug( "merge successful" );
			return result;
		} catch( RuntimeException re )
		{
			log.error( "merge failed", re );
			throw re;
		}
	}

	public void attachDirty( TShoppingcart instance )
	{
		log.debug( "attaching dirty TShoppingcart instance" );
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

	public void attachClean( TShoppingcart instance )
	{
		log.debug( "attaching clean TShoppingcart instance" );
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

	public static TShoppingcartDAO getFromApplicationContext(
			ApplicationContext ctx )
	{
		return (TShoppingcartDAO)ctx.getBean( "TShoppingcartDAO" );
	}
}