package by.pvt.shmouradko;

import by.pvt.shmouradko.dao.ILoginDAO;
import by.pvt.shmouradko.dao.LoginDAO;
import by.pvt.shmouradko.entities.Person;
import by.pvt.shmouradko.exceptions.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Сергей on 12.04.2016.
 */
@Service("loginService")
@Transactional
public class LoginService implements ILoginService{

    @Autowired
    private ILoginDAO dao;

//    private static LoginService instance;

    public LoginService(){
    }

//    public static LoginService getInstance() {
//        if (instance == null)
//            instance = new LoginService();
//        return instance;
//    }

    public Person checkPerson(String enterLogin, String enterPass, Person person){
        return dao.checkPerson(enterLogin, enterPass, person);
    }

}
