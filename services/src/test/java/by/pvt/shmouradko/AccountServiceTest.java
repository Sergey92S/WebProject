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
public class AccountServiceTest extends TestCase {

    @Autowired
    IAccountService accountService;

    @Test
    public void test() {
//        AccountService accountService = AccountService.getInstance();
//
        assertEquals(null, accountService.get(6));
        assertTrue(accountService.getValuesForAdmin() != null);
        assertEquals(true, accountService.isAccount(2222));
        assertEquals(1, accountService.getAccountId(1111));
        //assertEquals(1, accountService.changeStatus(1111));
        assertTrue(accountService.getValuesForUser("Login") != null);
        //assertEquals(1, accountService.changeCount(1111, 100));

    }

}
