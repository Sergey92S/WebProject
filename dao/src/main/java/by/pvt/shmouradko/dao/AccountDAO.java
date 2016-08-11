/**
 * 
 */
package by.pvt.shmouradko.dao;

import java.util.List;

import by.pvt.shmouradko.entities.Account;
import by.pvt.shmouradko.entities.AdminInfo;
import by.pvt.shmouradko.entities.UserInfo;
import by.pvt.shmouradko.exceptions.DaoException;
import by.pvt.shmouradko.utils.HibernateUtil;
import org.hibernate.*;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Shmouradko Sergey
 *
 */
@Repository("accountDAO")
public class AccountDAO extends BaseDAO<Account> implements IAccountDAO{
	//private static AccountDAO instance;
	//private Transaction transaction = null;
	private String SQL_SELECT_ADMIN_ACCOUNT = "select a.count as count, a.status as status, c.securityCode as securitycode, p.login as login, c.name as creditcard from person as p left join credit_card as c on p.Person_Id=c.Person_Id left join account as a on c.CreditCard_Id=a.CreditCard_Id where a.status=1";
	private String HQL_CHECK_ACCOUNT = "SELECT c.id FROM CreditCard c WHERE c.securityCode = :securityCode";
	private String SQL_SELECT_ACCOUNT = "select a.* from account as a, credit_card as c where (c.CreditCard_Id = a.CreditCard_Id) and (c.securityCode = :securityCode)";

	public AccountDAO() {

	}



//	private Session currentSession() {
//		util = HibernateUtil.getHibernateUtil();
//		Session session = util.getSession();
//		return session;
//	}

//	public static AccountDAO getInstance() {
//		if (instance == null)
//			instance = new AccountDAO();
//		return instance;
//	}

	/**
	 *This method returns a list of admins
	 * @return result - list of admins
	 */
	public List<AdminInfo> getValuesForAdmin() {
		List<AdminInfo> result;
//		try {
			//transaction = currentSession().beginTransaction();
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createSQLQuery(SQL_SELECT_ADMIN_ACCOUNT).addScalar("count", StandardBasicTypes.INTEGER).addScalar("status", StandardBasicTypes.INTEGER).addScalar("securitycode", StandardBasicTypes.INTEGER).addScalar("login", StandardBasicTypes.STRING).addScalar("creditcard", StandardBasicTypes.STRING).setResultTransformer(Transformers.aliasToBean(AdminInfo.class));
			result = query.list();
			//transaction.commit();
//		} catch(HibernateException e){
//			//transaction.rollback();
//			throw new DaoException(e);
//		}
//		util.closeSession();
		return result;
	}

	/**
	 *This method returns a list of users
	 * @param login - user's login
	 * @return result - list of users
	 */
	public List<UserInfo> getValuesForUser(String login){
		List<UserInfo> result;
//		try {
			//transaction = currentSession().beginTransaction();
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createSQLQuery("select a.count as count, a.status as status, c.securityCode as securitycode, c.name as name from account as a left join credit_card as c on c.CreditCard_Id=a.CreditCard_Id left join person as p on p.Person_Id=c.Person_Id where p.login='"+login+"'").addScalar("count", StandardBasicTypes.INTEGER).addScalar("status", StandardBasicTypes.INTEGER).addScalar("securitycode", StandardBasicTypes.INTEGER).addScalar("name", StandardBasicTypes.STRING).setResultTransformer(Transformers.aliasToBean(UserInfo.class));
			result = query.list();
			//transaction.commit();
//		} catch(HibernateException e){
//			//transaction.rollback();
//			throw new DaoException(e);
//		}
//		//util.closeSession();
		return result;
	}

	/**
	 *This method checks account by security code
	 * @param securityCode - account's security code
	 * @return true if there is such security code
	 */
	public boolean isAccount(int securityCode){
		boolean result = false;
//		try {
			//transaction = currentSession().beginTransaction();
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(HQL_CHECK_ACCOUNT).setParameter("securityCode", securityCode);
			if(query.list().size()>0)
				result = true;
			//transaction.commit();
//		} catch(HibernateException e){
//			//transaction.rollback();
//			throw new DaoException(e);
//		}
//		//util.closeSession();
		return result;
	}

	/**
	 *This method changes the status from user to admin
	 * @param securityCode - account's security code
	 */
	public int changeStatus(int securityCode){
		int result=-1;
//		try {
			//transaction = currentSession().beginTransaction();
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createSQLQuery("update account as a inner join credit_card as c on (c.CreditCard_Id = a.CreditCard_Id) set a.status=2 where c.securityCode = "+securityCode);
			result=query.executeUpdate();
			//transaction.commit();
//		} catch(HibernateException e){
//			//transaction.rollback();
//			throw new DaoException(e);
//		}
		//util.closeSession();
		return result;
	}

	/**
	 *This method returns account's id
	 * @param securityCode - account's security code
	 * @param sum - count of adding money
	 * @return result - account's id
	 */
	public int changeCount(int securityCode, int sum){
		int result=-1;
//		try {
			//transaction = currentSession().beginTransaction();
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createSQLQuery("update account as a inner join credit_card as c on (c.CreditCard_Id = a.CreditCard_Id) set a.count = (a.count + "+sum+") where c.securityCode = "+securityCode);
			result=query.executeUpdate();
			//transaction.commit();
//		} catch(HibernateException e){
//			//transaction.rollback();
//			throw new DaoException(e);
//		}
//		util.closeSession();
		return result;
	}

	/**
	 *This method returns account's id
	 * @param securityCode - account's security code
	 * @return result - account's id
	 */
	public int getAccountId(int securityCode){
		int result=-1;
//		try {
			//transaction = currentSession().beginTransaction();
			Session session = sessionFactory.getCurrentSession();
			Account account = (Account) session.createSQLQuery(SQL_SELECT_ACCOUNT).addEntity(Account.class).setParameter("securityCode", securityCode).uniqueResult();
			result=account.getId();
			//transaction.commit();
//		} catch(HibernateException e){
//			//transaction.rollback();
//			throw new DaoException(e);
//		}
//		util.closeSession();
		return result;
	}



}
