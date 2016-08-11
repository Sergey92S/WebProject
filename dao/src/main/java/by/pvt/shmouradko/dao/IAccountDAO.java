package by.pvt.shmouradko.dao;

import by.pvt.shmouradko.entities.Account;
import by.pvt.shmouradko.entities.AdminInfo;
import by.pvt.shmouradko.entities.UserInfo;

import java.util.List;

/**
 * Created by Сергей on 01.06.2016.
 */
public interface IAccountDAO extends DAO<Account>{
    List<AdminInfo> getValuesForAdmin();

    List<UserInfo> getValuesForUser(String login);

    boolean isAccount(int securityCode);

    int changeStatus(int securityCode);

    int changeCount(int securityCode, int sum);

    int getAccountId(int securityCode);

}
