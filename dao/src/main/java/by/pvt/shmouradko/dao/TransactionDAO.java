/**
 * 
 */
package by.pvt.shmouradko.dao;

import by.pvt.shmouradko.entities.Transaction;
import org.springframework.stereotype.Repository;

/**
 * @author Shmouradko Sergey
 *
 */
@Repository("transactionDAO")
public class TransactionDAO extends BaseDAO<Transaction> implements ITransactionDAO{
//	private static TransactionDAO instance;

	private TransactionDAO() {
	}

//	public static TransactionDAO getInstance() {
//		if (instance == null)
//			instance = new TransactionDAO();
//		return instance;
//	}

}
