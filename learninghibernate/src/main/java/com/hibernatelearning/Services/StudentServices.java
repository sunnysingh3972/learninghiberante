package com.hibernatelearning.Services;

import com.hibernatelearning.Entity.Student;
import com.hibernatelearning.Util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;;

public class StudentServices {
    private SessionFactory sessionFactory = HibernateUtil.sessionFactory;

    public void saveStudent(Student student) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Student getStudentById(int StudentId){
        try(Session session=sessionFactory.openSession()){
            Student student =session.find(Student.class, StudentId);
            return student;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
            
    }

    public Student updateStudent(int id,Student student){
        try(Session session=sessionFactory.openSession()){
            Transaction transaction =session.beginTransaction();
            Student existingStudent = session.find(Student.class, id);
            if(existingStudent==null){
                System.out.println("Student with id "+id+" not found.");
                return null;
            }
            existingStudent.setName(student.getName());
            existingStudent.setCollege(student.getCollege());
           // session.merge(student);
            transaction.commit();
            return existingStudent;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean deleteStudent(int id){
        try(Session session=sessionFactory.openSession()){
            Transaction transaction =session.beginTransaction();
            Student existingStudent = session.find(Student.class, id);
            if(existingStudent==null){
                System.out.println("Student with id "+id+" not found.");
                return false;
            }
            session.remove(existingStudent);
            transaction.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //HQL(JPA)-->native query 
    //database independent

    public List<Student> getAllStudentsHQL(){
        try(Session session=sessionFactory.openSession()){
            String hql="from Student";
            Query<Student> students =session.createQuery(hql,Student.class);
            return students.list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public Student getStudentByEmail(String email){
        try(Session session=sessionFactory.openSession()){
            String hql="from Student where email=:email";
            Query<Student> query =session.createQuery(hql,Student.class);
            query.setParameter("email", email);
            return query.uniqueResult();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //criteria API-->database independent

    public List<Student> getAllStudentsCriteria(String collegeName){
        try(Session session=sessionFactory.openSession()){
           HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
           CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
           Root<Student> from = query.from(Student.class);
           query.select(from).where(criteriaBuilder.equal(from.get("college"), collegeName));
              Query<Student> students = session.createQuery(query);
              return students.list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }


    //pagination
    public List<Student> getStudentBypagination(int pageNumber, int pageSize){
        try(Session session=sessionFactory.openSession()){
            String hql="from Student";
            Query<Student> query =session.createQuery(hql,Student.class);
            query.setFirstResult((pageNumber-1)*pageSize);
            query.setMaxResults(pageSize);
            return query.list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
