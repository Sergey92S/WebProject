package by.pvt.shmouradko;

import by.pvt.shmouradko.dao.IPersonDAO;
import by.pvt.shmouradko.dao.PersonDAO;
import by.pvt.shmouradko.entities.Person;
import by.pvt.shmouradko.exceptions.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * Created by Сергей on 12.04.2016.
 */
@Service("personService")
@Transactional
public class PersonService implements  IPersonService {

    @Autowired
    private IPersonDAO dao;

//    private static PersonService instance;

    public PersonService(){
    }

//    public static PersonService getInstance() {
//        if (instance == null)
//            instance = new PersonService();
//        return instance;
//    }

    public Person get(Serializable id){
        return dao.get(id);
    }

    public void register(Person person){
        dao.register(person);
    }

    public boolean checkLogin(String login){
        return dao.checkLogin(login);
    }

}
