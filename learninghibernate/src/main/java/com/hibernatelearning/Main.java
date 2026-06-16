package com.hibernatelearning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernatelearning.Entity.Student;
import com.hibernatelearning.Util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;

        Student student = new Student();
        student.setName("John Doe");
        student.setCollege("ABC University");
        student.setPhone("1234567890");
        student.setEmail("abc@gmail.com");
        student.setAbout("This is a sample student record.");

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(student);
            System.out.println("Student record saved successfully.");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}