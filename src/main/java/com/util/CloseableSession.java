package com.util;

import org.hibernate.Session;

/**
 * Created by pc8 on 15.04.16.
 */
public class CloseableSession implements AutoCloseable {

    private final Session session;

    public CloseableSession(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }


    public void close() {
        session.close();
    }

}
