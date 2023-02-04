package Day27_0121_Praktinis_darbas.repository;

import Day27_0121_Praktinis_darbas.entity.Customer;

import java.util.List;

import static Day27_0121_Praktinis_darbas.utility.HibernateUtilityPW.getSessionFactory;

public class CustomerRepo extends BaseRepo<Customer> {

    public List<Customer> findAll() {
        session = getSessionFactory().openSession();
        List<Customer> allCustomers = session.createQuery("FROM Customer", Customer.class).list();
        session.close();
        return allCustomers;
    }

    @Override
    public void saveList(List<Customer> givenList) {
        session = getSessionFactory().openSession();
        transaction = session.beginTransaction();
        givenList.forEach(customer -> session.save(customer));
        transaction.commit();
        session.close();
    }
}
