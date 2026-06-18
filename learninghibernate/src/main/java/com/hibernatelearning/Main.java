package com.hibernatelearning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernatelearning.Entity.Certicate;
import com.hibernatelearning.Entity.Student;
import com.hibernatelearning.Services.StudentServices;
import com.hibernatelearning.Util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;

        Student student = new Student();
        student.setName("Sunny Doe");
        student.setCollege("ABC University");
        student.setPhone("1232567890");
        student.setEmail("abca@gmail.com");
        student.setAbout("This is a samsaple student record.");

        Certicate certificate1 = new Certicate();
        certificate1.setCertificateName("Java Programming");
        certificate1.setLink("https://www.example.com/java-certificate "); 

         Certicate certificate2 = new Certicate();
        certificate2.setCertificateName("AS Programming");
        certificate2.setLink("https://www.example.com/javas-certificate "); 
        student.getCertificates().add(certificate1);
        student.getCertificates().add(certificate2);
        certificate1.setStudent(student);
        certificate2.setStudent(student);

        StudentServices studentServices = new StudentServices();
        
        System.out.println(studentServices.getStudentById(1));
        // Session session = sessionFactory.openSession();
        // Transaction transaction = null;
        // try {
        //     transaction = session.beginTransaction();
        //     session.persist(student);
        //     System.out.println("Student record saved successfully.");
        //     transaction.commit();
        // } catch (Exception e) {
        //     if (transaction != null) {
        //         transaction.rollback();
        //     }
        //     e.printStackTrace();
        // } finally {
        //     session.close();
        // }
    }
}