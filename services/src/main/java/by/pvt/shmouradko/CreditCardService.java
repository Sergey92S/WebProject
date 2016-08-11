package by.pvt.shmouradko;

import by.pvt.shmouradko.dao.CreditCardDAO;
import by.pvt.shmouradko.dao.ICreditCardDAO;
import by.pvt.shmouradko.entities.CreditCard;
import by.pvt.shmouradko.exceptions.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * Created by Сергей on 12.04.2016.
 */
@Service("creditCardService")
@Transactional
public class CreditCardService implements ICreditCardService{

    @Autowired
    private ICreditCardDAO dao;

//    private static CreditCardService instance;

    public CreditCardService(){
    }

//    public static CreditCardService getInstance() {
//        if (instance == null)
//            instance = new CreditCardService();
//        return instance;
//    }

    public int checkPersonId(String login){
        return dao.checkPersonId(login);
    }

    public int checkCreditCardId(int securityCode) {
        return dao.checkCreditCardId(securityCode);
    }

    public boolean checkSecurityCode(int securityCode){
        return dao.checkSecurityCode(securityCode);
    }

    public void register(CreditCard creditcard) {
        dao.register(creditcard);
    }

    public CreditCard get(Serializable id){
        return dao.get(id);
    }

}
