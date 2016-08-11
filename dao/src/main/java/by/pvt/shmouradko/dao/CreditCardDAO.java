/**
 * 
 */
package by.pvt.shmouradko.dao;

import by.pvt.shmouradko.entities.CreditCard;
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
@Repository("creditCardDAO")
public class CreditCardDAO extends BaseDAO<CreditCard> implements ICreditCardDAO {
	private static CreditCardDAO instance;
	private String HQL_CHECK_LOGIN = "FROM Person p WHERE p.login = :login";
	private String HQL_CHECK_SECURITY_CODE = "SELECT c.id FROM CreditCard c WHERE c.securityCode = :securityCode";
	private String HQL_CHECK_ID = "FROM CreditCard c WHERE c.securityCode = :securityCode";

//	private Transaction transaction = null;

	private CreditCardDAO() {
	}

//	private Session currentSession() {
//		util = HibernateUtil.getHibernateUtil();
//		Session session = util.getSession();
//		return session;
//	}
//
//	public static CreditCardDAO getInstance() {
//		if (instance == null)
//			instance = new CreditCardDAO();
//		return instance;
//	}

	/**
	 *This method checks person's id
	 * @param login - person's login
	 * @return result - person's id
	 */
	public int checkPersonId(String login) {
		int result = -1;
//		try {
//			transaction = currentSession().beginTransaction();
			Session session = sessionFactory.getCurrentSession();
			Person person = (Person) session.createQuery(HQL_CHECK_LOGIN).setParameter("login", login).uniqueResult();
			result=person.getId();
//			transaction.commit();
//		} catch(HibernateException e){
//			transaction.rollback();
//			throw new DaoException(e);
//		}
//		util.closeSession();
		return result;
	}

	/**
	 * This method checks security code
	 * @param securityCode - account's security code
	 * @return false if such security code has already exsist
	 */
	public boolean checkSecurityCode(int securityCode){
		boolean result = true;
//		try {
//			transaction = currentSession().beginTransaction();
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(HQL_CHECK_SECURITY_CODE).setParameter("securityCode", securityCode);
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

	/**
	 *This method checks credit card id
	 * @param securityCode - person's credit card
	 * @return result - credit card id
	 */
	public int checkCreditCardId(int securityCode){
		int result = -1;
//		try {
//			transaction = currentSession().beginTransaction();
			Session session = sessionFactory.getCurrentSession();
			CreditCard creditCard = (CreditCard) session.createQuery(HQL_CHECK_ID).setParameter("securityCode", securityCode).uniqueResult();
			result=creditCard.getId();
//			transaction.commit();
//		} catch(HibernateException e){
//			transaction.rollback();
//			throw new DaoException(e);
//		}
//		util.closeSession();
		return result;
	}

}
