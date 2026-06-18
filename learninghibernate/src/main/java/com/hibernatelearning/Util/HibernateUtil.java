package com.hibernatelearning.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatelearning.Entity.Certicate;
import com.hibernatelearning.Entity.Student;

public class HibernateUtil {
    public static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().addAnnotatedClass(Student.class)
            .addAnnotatedClass(Certicate.class)
            .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
