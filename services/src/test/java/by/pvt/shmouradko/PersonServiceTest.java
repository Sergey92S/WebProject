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
public class PersonServiceTest extends TestCase {

    @Autowired
    IPersonService personService;

    @Test
    public void test() {
//        PersonService personService = PersonService.getInstance();
        assertEquals(false, personService.checkLogin("Login"));
//
////        TransactionService transactionService = TransactionService.getInstance();
////        try{
////            //transaction.setAccountId(accountService.getAccountId(securitycode));
////            assertEquals(1, transactionService.transactionManager(100, 1111));
////        } catch (DaoException e) {
////            e.printStackTrace();
////        }
    }

}
