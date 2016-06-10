package com.dao.implement;

import com.exception.DaoException;
import com.util.CloseableSession;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pc8 on 18.04.16.
 */
@Repository
public class GenericDao<T> {

    private static final Logger logger = Logger.getLogger(GenericDao.class);

    @Autowired
    protected SessionFactory sessionFactory;


    protected void set(T t) {


        try (CloseableSession closeableSession = new CloseableSession(sessionFactory.openSession())) {

            closeableSession.getSession().beginTransaction();
            closeableSession.getSession().save(t);
            closeableSession.getSession().getTransaction().commit();

        } catch (Exception e) {
            logger.error(e);
            throw new DaoException(e);
        }
    }

    protected T get(Long id, Class clazz) {
        try (CloseableSession closeableSession = new CloseableSession(sessionFactory.openSession())) {
            Session session = closeableSession.getSession();
            return (T) session.get(clazz, id);

        } catch (Exception e) {
            logger.error(e);
            throw new DaoException(e);
        }
    }

    protected List<T> getAll(Class clazz) {
        try (CloseableSession closeableSession = new CloseableSession(sessionFactory.openSession())) {
            Session session = closeableSession.getSession();
            Criteria criteria = session.createCriteria(clazz);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            return (List<T>) criteria.list();

        } catch (Exception e) {
            logger.error(e);
            throw new DaoException(e);
        }
    }

    protected void update(T t) {
        try (CloseableSession closeableSession = new CloseableSession(sessionFactory.openSession())) {

            closeableSession.getSession().beginTransaction();
            closeableSession.getSession().update(t);
            closeableSession.getSession().getTransaction().commit();

        } catch (Exception e) {
            logger.error(e);
            throw new DaoException(e);
        }
    }

    protected void delete(T t) {
        try (CloseableSession closeableSession = new CloseableSession(sessionFactory.openSession())) {

            closeableSession.getSession().beginTransaction();
            closeableSession.getSession().delete(t);
            closeableSession.getSession().getTransaction().commit();

        } catch (Exception e) {
            logger.error(e);
            throw new DaoException(e);
        }
    }

    protected T getByName(String name, Class clazz) {
        try (CloseableSession closeableSession = new CloseableSession(sessionFactory.openSession())) {
            Session session = closeableSession.getSession();
            return (T) session.createCriteria(clazz).add(Restrictions.like("name", name)).uniqueResult();

        } catch (Exception e) {
            logger.error(e);
            throw new DaoException(e);
        }
    }

}
