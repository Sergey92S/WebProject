package by.pvt.shmouradko;

import by.pvt.shmouradko.entities.Person;

import java.io.Serializable;

/**
 * Created by Сергей on 01.06.2016.
 */
public interface IPersonService {

    Person get(Serializable id);

    void register(Person person);

    boolean checkLogin(String login);

}
