package by.pvt.shmouradko.dao;

import by.pvt.shmouradko.exceptions.DaoException;

import java.io.Serializable;

/**
 * Created by test on 13.05.2016.
 */
public interface DAO<T> {
    void register(T item);
    T get(Serializable id);
}
