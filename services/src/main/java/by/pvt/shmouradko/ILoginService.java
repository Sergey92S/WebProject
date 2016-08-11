package by.pvt.shmouradko;

import by.pvt.shmouradko.entities.Person;

/**
 * Created by Сергей on 01.06.2016.
 */
public interface ILoginService {

    Person checkPerson(String enterLogin, String enterPass, Person person);

}
