package by.pvt.shmouradko.dao;

import by.pvt.shmouradko.exceptions.DaoException;
import by.pvt.shmouradko.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by test on 13.05.2016.
 */
@Repository("BaseDAO")
public class BaseDAO<T> implements DAO<T> {
    private static Logger log = Logger.getLogger(BaseDAO.class);
//    private Transaction transaction = null;
//    public static HibernateUtil util;

    @Autowired
    protected SessionFactory sessionFactory;

    public BaseDAO() {
    }

    /**
     * This method register a new entity
     * @param item - is an entity`s template
     */
    public void register(T item) {
//        try {
//            util = HibernateUtil.getHibernateUtil();
//            Session session = util.getSession();
//            transaction = session.beginTransaction();
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(item);
            log.info("saveOrUpdate(person):" + item);
//            transaction.commit();
//            log.info("Save or update (commit):" + item);
//        } catch (HibernateException e) {
//            log.error("Error save or update PERSON in DAO" + e);
//            transaction.rollback();
//            throw new DaoException(e);
//        }
//        util.closeSession();
    }

    public T get(Serializable id) {
        log.info("Get class by id:" + id);
        T item = null;
//        try {
//            util = HibernateUtil.getHibernateUtil();
//            Session session = util.getSession();
//            transaction = session.beginTransaction();
            Session session = sessionFactory.getCurrentSession();
            item = (T) session.get(getPersistentClass(), id);
//            transaction.commit();
//            log.info("get clazz:" + item);
//        } catch (HibernateException e) {
//            transaction.rollback();
//            log.error("Error get " + getPersistentClass() + " in Dao" + e);
//            throw new DaoException(e);
//        }
//        util.closeSession();
        return item;
    }

    private Class getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
