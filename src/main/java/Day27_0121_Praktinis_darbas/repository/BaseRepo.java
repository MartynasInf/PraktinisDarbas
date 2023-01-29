package Day27_0121_Praktinis_darbas.repository;

import Day27_0121_Praktinis_darbas.interfaces.Persistable;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static Day27_0121_Praktinis_darbas.utility.HibernateUtilityPW.getSessionFactory;

public abstract class BaseRepo <T> {
    public Session session;
    public Transaction transaction;

    public void save(Persistable persistable) {
        session = getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(persistable);
        transaction.commit();
        session.close();
    }
    public void update(Persistable persistable){
        session = getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.update(persistable);
        transaction.commit();
        session.close();
    }
    public void delete(Persistable persistable){
        session = getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.delete(persistable);
        transaction.commit();
        session.close();
    }
    public abstract List<T> findAll();

    public abstract void saveList(List<T> givenList);

}
