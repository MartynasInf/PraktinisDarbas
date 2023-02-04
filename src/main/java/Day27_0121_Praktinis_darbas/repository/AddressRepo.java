package Day27_0121_Praktinis_darbas.repository;

import Day27_0121_Praktinis_darbas.entity.Address;

import java.util.List;

import static Day27_0121_Praktinis_darbas.utility.HibernateUtilityPW.getSessionFactory;

public class AddressRepo extends BaseRepo <Address> {
    @Override
    public List<Address> findAll() {
        session = getSessionFactory().openSession();
        List<Address> addressList = session.createQuery("FROM Address", Address.class).list();
        session.close();
        return addressList;
    }

    @Override
    public void saveList(List<Address> givenList) {
        session = getSessionFactory().openSession();
        transaction = session.beginTransaction();
        givenList.forEach(address -> session.save(address));
        transaction.commit();
        session.close();
    }
}
