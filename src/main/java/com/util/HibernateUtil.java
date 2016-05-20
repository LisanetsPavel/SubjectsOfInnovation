package com.util;

import com.exception.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

/**
 * Created by pc8 on 14.04.16.
 */

public class HibernateUtil {

    private static final Logger logger = Logger.getLogger(HibernateUtil.class);

    private static SessionFactory sessionFactory = null;

    static {
        try {

            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
           logger.error(e);
           throw new DaoException();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
