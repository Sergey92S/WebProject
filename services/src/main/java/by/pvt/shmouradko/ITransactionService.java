package by.pvt.shmouradko;

import by.pvt.shmouradko.entities.Transaction;

import java.io.Serializable;

/**
 * Created by Сергей on 01.06.2016.
 */
public interface ITransactionService {

    Transaction get(Serializable id);

    void register(Transaction transaction);

    int transactionManager(int sum, int securityCode);

}
