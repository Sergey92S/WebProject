package by.pvt.shmouradko.dao;

import by.pvt.shmouradko.entities.Person;

/**
 * Created by Сергей on 01.06.2016.
 */
public interface ILoginDAO {

    Person checkPerson(String enterLogin, String enterPass, Person person);

}
