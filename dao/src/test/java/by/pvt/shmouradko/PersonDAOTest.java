package by.pvt.shmouradko;

import by.pvt.shmouradko.dao.IPersonDAO;
import by.pvt.shmouradko.dao.PersonDAO;
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
@ContextConfiguration("classpath: test-dao.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PersonDAOTest extends TestCase {

    @Autowired
    IPersonDAO personDAO;

    @Test
    public void test() {
//        PersonDAO personDAO = PersonDAO.getInstance();
        assertEquals(false, personDAO.checkLogin("Login"));
    }

}
