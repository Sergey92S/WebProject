/**
 * 
 */
package by.pvt.shmouradko.dao;

import by.pvt.shmouradko.entities.Person;
import by.pvt.shmouradko.exceptions.DaoException;
import by.pvt.shmouradko.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 * @author Shmouradko Sergey
 *
 */
@Repository("personDAO")
public class PersonDAO extends BaseDAO<Person> implements IPersonDAO{
//	private static PersonDAO instance;
	private String HQL_CHECK_LOGIN = "SELECT p.id FROM Person p WHERE p.login = :login";
//	private Transaction transaction = null;

	private PersonDAO() {
	}

//	private Session currentSession() {
//		util = HibernateUtil.getHibernateUtil();
//		Session session = util.getSession();
//		return session;
//	}
//
//	public static PersonDAO getInstance() {
//		if (instance == null)
//			instance = new PersonDAO();
//		return instance;
//	}

	/**
	 *This method checks person's login
	 * @param login - person's login
	 * @return false if this login is already exsists
	 */
	public boolean checkLogin(String login) {
		boolean result = true;
//		try {
//			transaction = currentSession().beginTransaction();
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(HQL_CHECK_LOGIN).setParameter("login", login);
			if(query.list().size()>0)
				result = false;
//			transaction.commit();
//		} catch(HibernateException e){
//			transaction.rollback();
//			throw new DaoException(e);
//		}
//		util.closeSession();
		return result;
	}

}
