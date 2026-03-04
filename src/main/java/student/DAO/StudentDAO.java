package student.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import student.entity.Student;
import student.util.HibernateUtil;

import java.util.List;

public class StudentDAO {


    public void saveStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(student);

        tx.commit();
        session.close();
    }

    public List<Student> getAllStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Student> students = session.createQuery("from Student", Student.class).list();
        session.close();
        return students;
    }

    public void updateStudent(Long id,String newName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, id);
        if (student != null) {
            student.setName(newName);
        }

        tx.commit();
        session.close();
    }

    public void deleteStudent(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class,id);
        if(student != null) {
            session.remove(student);
        }

        tx.commit();
        session.close();
    }
}
