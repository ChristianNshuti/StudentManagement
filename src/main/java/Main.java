package student;

import student.entity.Student;
import student.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Student student = new Student("Christian","chrisnshuti943@gmail.com",18);

        session.persist(student);

        transaction.commit();
        session.close();

        System.out.println("Student saved successfully!");
    }
}