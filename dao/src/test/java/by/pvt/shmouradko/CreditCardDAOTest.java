package by.pvt.shmouradko;

import by.pvt.shmouradko.dao.CreditCardDAO;
import by.pvt.shmouradko.dao.ICreditCardDAO;
import by.pvt.shmouradko.exceptions.DaoException;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Сергей on 14.04.2016.
 */
@ContextConfiguration("/test-dao.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CreditCardDAOTest extends TestCase {

    @Autowired
    ICreditCardDAO creditCardDAO;

    @Test
    public void test() {
//        CreditCardDAO creditcardDAO = CreditCardDAO.getInstance();
//
        assertEquals(2, creditCardDAO.checkPersonId("admin"));
        assertEquals(false, creditCardDAO.checkSecurityCode(1111));
        assertEquals(2, creditCardDAO.checkCreditCardId(2222));

    }

}
