package Day26_0114.TeamWork.repository;



import Day26_0114.TeamWork.entity.Teacher;
import Day26_0114.TeamWork.util.HibernateUtility3;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TeacherRepo {

    public void save(Teacher teacher){
        Session session = HibernateUtility3.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(teacher);
        transaction.commit();
        session.close();
    }

    public void delete (Long id) {
        Session session = HibernateUtility3.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Teacher teacher = session.get(Teacher.class, id);
        session.delete(teacher);
        transaction.commit();
        session.close();
    }
    public void update (Teacher teacher){
        Session session = HibernateUtility3.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(teacher);
        transaction.commit();
        session.close();
    }
    public List<Teacher> findAll(){
        Session session = HibernateUtility3.getSessionFactory().openSession();
        return session.createQuery("FROM Teacher", Teacher.class).list();
    }
}
