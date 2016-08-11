package by.pvt.shmouradko;

import by.pvt.shmouradko.dao.AccountDAO;
import by.pvt.shmouradko.dao.IAccountDAO;
import by.pvt.shmouradko.exceptions.DaoException;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Сергей on 13.04.2016.
 */
@ContextConfiguration("/test-dao.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class AccountDAOTest extends TestCase{

    @Autowired
    IAccountDAO accountDAO;

    @Test
    public void test() {
//        AccountDAO accountDAO = AccountDAO.getInstance();
//
        assertEquals(null, accountDAO.get(7));
        assertTrue(accountDAO.getValuesForAdmin() != null);
        assertEquals(true, accountDAO.isAccount(2222));
        assertEquals(1, accountDAO.getAccountId(1111));
        //assertEquals(1, accountDAO.changeStatus(1111));
        assertTrue(accountDAO.getValuesForUser("Login") != null);

    }

}
