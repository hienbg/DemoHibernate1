package com.vti.rw41.utils;

import com.vti.rw41.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
    public static SessionFactory getSessionFactory() {
        /*Load configuration*/
        Configuration configuration = new Configuration();
        configuration.configure("Hibernate.cfg.xml");

        /*Add Entity*/
        /*Them bao nhieu Class cung dc ?*/
        configuration.addAnnotatedClass(Account.class);
        configuration.addAnnotatedClass(Group.class);
        configuration.addAnnotatedClass(TestUuid.class);
        configuration.addAnnotatedClass(Student.class);

        configuration.addAnnotatedClass(BillDetail.class);


        ServiceRegistry registry = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(registry);

    }
}
