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
public class LoginServiceTest extends TestCase {

    @Autowired
    ILoginService loginService;

    @Test
    public void test() {
//        LoginService loginService = LoginService.getInstance();
        assertTrue(loginService.checkPerson("admin", "admin", null).getName().equals("admin"));
    }

}
