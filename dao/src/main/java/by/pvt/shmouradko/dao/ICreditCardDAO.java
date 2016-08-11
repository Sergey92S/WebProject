package by.pvt.shmouradko.dao;

import by.pvt.shmouradko.entities.CreditCard;

/**
 * Created by Сергей on 01.06.2016.
 */
public interface ICreditCardDAO extends DAO<CreditCard>{

    int checkPersonId(String login);

    boolean checkSecurityCode(int securityCode);

    int checkCreditCardId(int securityCode);

}
