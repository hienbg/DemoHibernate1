package com.vti.rw41.repository;

import com.vti.rw41.entity.Account;
import com.vti.rw41.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AccountRepository {
    public static List<Account> findByName(String name) {
        /*Open a session*/
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            /*Create a HQL statement*/
            Query<Account> query = session.createQuery("FROM Account WHERE username = :accountName", Account.class);
            /*Set parameter*/
            query.setParameter("accountName", name);
            /*Return a list result*/
            return query.getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static Account findById(Integer id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        return session.find(Account.class, id);
    }

    public static Account saveOrUpdate(Account account) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(account);
        session.getTransaction().commit();
        return account;
    }

    public static Account delete(Account account) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(account);
        session.getTransaction().commit();
        return account;
    }
}
