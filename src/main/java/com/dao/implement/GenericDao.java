package com.dao.implement;

import com.util.CloseableSession;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pc8 on 18.04.16.
 */
@Repository
public class GenericDao<T>  {

     protected void set( T t){
        try (CloseableSession closeableSession = new CloseableSession(HibernateUtil.getSessionFactory().openSession())){

            closeableSession.getSession().beginTransaction();
            closeableSession.getSession().save(t);
            closeableSession.getSession().getTransaction().commit();

        }
    }

    protected T get(Long id, Class clazz){
        try (CloseableSession closeableSession = new CloseableSession(HibernateUtil.getSessionFactory().openSession())){
            Session session = closeableSession.getSession();
            return  (T)  session.get( clazz, id);

        }
    }

    protected List<T> getAll(Class clazz){
        try (CloseableSession closeableSession = new CloseableSession(HibernateUtil.getSessionFactory().openSession())){
            Session session = closeableSession.getSession();
            return  (List<T>) session.createCriteria(clazz).list();

        }
    }

    protected void update(T t){
        try (CloseableSession closeableSession = new CloseableSession(HibernateUtil.getSessionFactory().openSession())){

            closeableSession.getSession().beginTransaction();
            closeableSession.getSession().update(t);
            closeableSession.getSession().getTransaction().commit();

        }
    }

    protected void delete(T t){
        try (CloseableSession closeableSession = new CloseableSession(HibernateUtil.getSessionFactory().openSession())){

            closeableSession.getSession().beginTransaction();
            closeableSession.getSession().delete(t);
            closeableSession.getSession().getTransaction().commit();

        }
    }

    protected T getByName(String name, Class clazz){
        try (CloseableSession closeableSession = new CloseableSession(HibernateUtil.getSessionFactory().openSession())){
            Session session = closeableSession.getSession();
            return  (T) session.createCriteria(clazz).add(Restrictions.like("name", name)).uniqueResult();

        }
    }

}
