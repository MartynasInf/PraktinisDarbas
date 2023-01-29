package Day26_0114.Homework.repository;

import Day26_0114.Homework.entity.House;
import Day26_0114.Homework.entity.Owner;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static Day26_0114.Homework.utility.HibernateUtility4.getSessionFactory;

public class HouseRepo {

    public void save(House house){
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(house);
        transaction.commit();
        session.close();
    }
    public void delete(House house){
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(house);
        transaction.commit();
        session.close();
    }

    public void update(House house){
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(house);
        transaction.commit();
        session.close();
    }

    public List<House> findAll(){
        Session session = getSessionFactory().openSession();
        List<House> allHouses = session.createQuery("FROM House", House.class).list();
        session.close();
        return allHouses;
    }

}
