package Day26_0114.Homework.repository;

import Day26_0114.Homework.entity.Owner;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static Day26_0114.Homework.utility.HibernateUtility4.getSessionFactory;

public class OwnerRepo {

    public void save(Owner owner){
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(owner);
        transaction.commit();
        session.close();
    }

    public void delete(Owner owner){
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(owner);
        transaction.commit();
        session.close();
    }

    public void update(Owner owner){
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(owner);
        transaction.commit();
        session.close();
    }
    public List<Owner> findAll(){
        Session session = getSessionFactory().openSession();
        List<Owner> allOwners = session.createQuery("FROM Owner", Owner.class).list();
        session.close();
        return  allOwners;
    }
}
