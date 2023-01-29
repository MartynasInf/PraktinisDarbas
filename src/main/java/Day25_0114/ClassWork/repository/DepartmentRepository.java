package Day25_0114.ClassWork.repository;

import Day25_0114.ClassWork.entity.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Day25_0114.ClassWork.utils.HibernateUtil;

import java.util.List;

/**
 * Repository provided methods to execute actions with Department table such as:
 * 1. Save +
 * 2. Update
 * 3. Delete +
 * 4. Get/Fetch
 * 5. Get All +
 */
public class DepartmentRepository {

    public void save(Department department){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(department);
        transaction.commit();
        session.close();
    }

    public void delete(Department department){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(department);
        transaction.commit();
        session.close();
    }

    public List<Department> findAll (){
        Session session = HibernateUtil.getSessionFactory().openSession();
        //session.find() suranda objekta pagal duota id
        //List<Department> allDepos = session.createQuery("FROM Department", Department.class).list();
        return session.createQuery("FROM Department", Department.class).list();
    }

}
