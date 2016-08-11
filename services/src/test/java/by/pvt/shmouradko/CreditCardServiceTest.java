package by.pvt.shmouradko;

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
@ContextConfiguration("/test-service.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CreditCardServiceTest extends TestCase {

    @Autowired
    ICreditCardService creditCardService;

    @Test
    public void test() {
//        CreditCardService creditcardService = CreditCardService.getInstance();
//
        assertEquals(2, creditCardService.checkPersonId("admin"));
        assertEquals(false, creditCardService.checkSecurityCode(1111));
        assertEquals(1, creditCardService.checkCreditCardId(1111));

    }

}
