/**
 * 
 */
package by.pvt.shmouradko.dao;

import by.pvt.shmouradko.entities.Person;
import by.pvt.shmouradko.exceptions.DaoException;
import by.pvt.shmouradko.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 * @author Shmouradko Sergey
 *
 */
@Repository("loginDAO")
public class LoginDAO extends BaseDAO implements ILoginDAO{
//	private static LoginDAO instance;
	//private Transaction transaction = null;
	private String HQL_SELECT_PERSON = "FROM Person p WHERE (p.login = :login"+") AND (p.password = :password"+")";

	private LoginDAO() {
	}

//	private Session currentSession() {
//		util = HibernateUtil.getHibernateUtil();
//		Session session = util.getSession();
//		return session;
//	}
//
//	public static LoginDAO getInstance() {
//		if (instance == null)
//			instance = new LoginDAO();
//		return instance;
//	}

	/**
	 *This method checks person
	 * @param enterLogin - person's login, enterPass - person's password, person - entity of person
	 * @param person - person's entity
	 * @return person with filled fields
	 */
	public Person checkPerson(String enterLogin, String enterPass, Person person) {
//		try {
			//transaction = currentSession().beginTransaction();
			Session session = sessionFactory.getCurrentSession();
			person = (Person) session.createQuery(HQL_SELECT_PERSON).setParameter("login", enterLogin).setParameter("password", enterPass).uniqueResult();
			//transaction.commit();
//		} catch(HibernateException e){
//			//transaction.rollback();
//			throw new DaoException(e);
//		}
//		util.closeSession();
		return person;
	}

}
