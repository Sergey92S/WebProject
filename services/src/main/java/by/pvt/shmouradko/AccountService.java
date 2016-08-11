package by.pvt.shmouradko;

import by.pvt.shmouradko.dao.AccountDAO;
import by.pvt.shmouradko.dao.IAccountDAO;
import by.pvt.shmouradko.entities.Account;
import by.pvt.shmouradko.entities.AdminInfo;
import by.pvt.shmouradko.entities.UserInfo;
import by.pvt.shmouradko.exceptions.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Сергей on 12.04.2016.
 */
@Service("accountService")
@Transactional
public class AccountService implements IAccountService{

    @Autowired
    private IAccountDAO dao;

//    private static AccountService instance;

    public AccountService(){
    }

//    public static AccountService getInstance() {
//        if (instance == null)
//            instance = new AccountService();
//        return instance;
//    }

    public Account get(Serializable id){
        return dao.get(id);
    }

    public void register(Account account){
        dao.register(account);
    }

    public List<AdminInfo> getValuesForAdmin(){
        return dao.getValuesForAdmin();
    }

    public List<UserInfo> getValuesForUser(String login){
        return dao.getValuesForUser(login);
    }

    public boolean isAccount(int securityCode){
        return dao.isAccount(securityCode);
    }

    public int changeStatus(int securityCode){
        return dao.changeStatus(securityCode);
    }

    public int changeCount(int securityCode, int sum){
        return dao.changeCount(securityCode, sum);
    }

    public int getAccountId(int securityCode){
        return dao.getAccountId(securityCode);
    }
}
