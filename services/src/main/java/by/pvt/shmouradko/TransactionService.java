package by.pvt.shmouradko;

import by.pvt.shmouradko.dao.ITransactionDAO;
import by.pvt.shmouradko.dao.TransactionDAO;
import by.pvt.shmouradko.entities.Transaction;
import by.pvt.shmouradko.exceptions.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * Created by Сергей on 12.04.2016.
 */
@Service("transactionService")
@Transactional
public class TransactionService implements ITransactionService{

    @Autowired
    private ITransactionDAO dao;

    @Autowired
    private Transaction transaction;

    @Autowired
    private IAccountService accountService;

//    private static TransactionService instance;

    public TransactionService(){
    }

//    public static TransactionService getInstance() {
//        if (instance == null)
//            instance = new TransactionService();
//        return instance;
//    }

    public Transaction get(Serializable id) {
        return dao.get(id);
    }

    public void register(Transaction transaction) {
        dao.register(transaction);
    }

    /**
     *
     * @param sum - count of adding money
     * @param securityCode - credit card security code
     * @return result - returns 1 when it's correct
     * @throws DaoException
     */
    public int transactionManager(int sum, int securityCode) {
        int result = -1;
        transaction.setSum(sum);
        transaction.setAccount(accountService.get(accountService.getAccountId(securityCode)));
        register(transaction);
        result = accountService.changeCount(securityCode, sum);
        return result;
    }

}
