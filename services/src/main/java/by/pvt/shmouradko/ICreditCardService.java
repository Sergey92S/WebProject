package by.pvt.shmouradko;

import by.pvt.shmouradko.entities.CreditCard;

import java.io.Serializable;

/**
 * Created by Сергей on 01.06.2016.
 */
public interface ICreditCardService {

    int checkPersonId(String login);

    int checkCreditCardId(int securityCode);

    boolean checkSecurityCode(int securityCode);

    void register(CreditCard creditcard);

    CreditCard get(Serializable id);

}
